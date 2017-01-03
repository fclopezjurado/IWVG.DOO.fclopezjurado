/**
 * 
 */
package es.upm.miw.models;

import java.util.ArrayList;
import java.util.HashMap;

import es.upm.miw.utils.IO;

/**
 * @author FCL
 *
 */
public class Tableau {
	public static final int PILES = 7;

	private Deck deck;
	private Waste waste;
	private HashMap<Suit, Foundation> foundations;
	private ArrayList<Pile> piles;

	/**
	 * 
	 */
	protected Tableau() {
		this.deck = new Deck();
		this.waste = new Waste();
		this.foundations = new HashMap<Suit, Foundation>();
		this.piles = new ArrayList<Pile>();

		this.initDeck();
		this.initFoundations();
		this.initPiles();
	}

	/**
	 * 
	 */
	private void initDeck() {
		while (this.deck.numberOfCards() < Deck.SIZE) {
			Card card = new Card();

			if (!this.deck.isStackable(card))
				this.deck.push(card);
		}
	}

	/**
	 * 
	 */
	private void initFoundations() {
		for (Suit suit : Suit.values())
			this.foundations.put(suit, new Foundation());
	}

	/**
	 * 
	 */
	private void initPiles() {
		for (int numberOfPiles = 1; numberOfPiles <= PILES; numberOfPiles++) {
			Pile pile = new Pile();

			for (int cardsInPile = PILES; cardsInPile >= numberOfPiles; cardsInPile--) {
				if (cardsInPile == numberOfPiles)
					pile.push(this.deck.pull().turn());
				else
					pile.push(this.deck.pull());
			}

			this.piles.add(pile);
		}
	}

	/**
	 * @return
	 */
	public boolean areFoundationsFull() {
		for (HashMap.Entry<Suit, Foundation> foundation : this.foundations.entrySet())
			if (foundation.getValue().numberOfCards() < CardNumber.values().length)
				return false;

		return true;
	}

	/**
	 * @param origin
	 * @param destiny
	 * @param cards
	 */
	private void moveCards(Stack origin, Stack destiny, int cards) {
		assert origin != null;
		assert destiny != null;
		assert cards > 0;

		if (cards > origin.numberOfCards())
			cards = origin.numberOfCards();

		for (int index = 0; index < cards; index++)
			destiny.push(origin.pull());
	}

	/**
	 * 
	 */
	public void moveToWaste() {
		this.moveToDeck();
		this.moveCards(this.deck, this.waste, Waste.SIZE);
		this.waste.upturnCards();
	}

	/**
	 * 
	 */
	public void moveToDeck() {
		this.moveCards(this.waste, this.deck, Waste.SIZE);
	}

	/**
	 * 
	 */
	public boolean moveFromWasteToFoundation() {
		if (!this.waste.isEmpty()) {
			Card firstCardInWaste = this.waste.getFirstCard();
			Foundation involvedFoundation = this.foundations.get(firstCardInWaste.getPip());
			
			if (involvedFoundation.isStackable(firstCardInWaste)) {
				involvedFoundation.push(this.waste.pull());
				return true;
			}
		}

		return false;
	}

	public boolean moveFromWasteToPile(int numberOfPile) {
		if (!this.waste.isEmpty()) {
			Card firstCardInWaste = this.waste.getFirstCard();
			Pile involvedPile = this.piles.get(numberOfPile - 1);

			if (involvedPile.isStackable(firstCardInWaste)) {
				involvedPile.push(this.waste.pull());
				return true;
			}
		}

		return false;
	}

	/**
	 * 
	 */
	public void write() {
		IO.getInstance().writeln(IO.DOUBLE_HORIZONTAL_LINE);

		/**
		 * PRINT DECK
		 */

		IO.getInstance().write("Baraja: ");

		if (this.deck.isEmpty())
			IO.getInstance().writeln("<vacío>");
		else
			IO.getInstance().writeln("[X,X]");

		/**
		 * PRINT WASTE
		 */

		IO.getInstance().write("Descarte: ");

		if (this.waste.isEmpty())
			IO.getInstance().writeln("<vacío>");
		else {
			for (Card card : this.waste.getCards())
				IO.getInstance().write(card.toString());

			IO.getInstance().writeln();
		}

		/**
		 * PRINT FOUNDATIONS
		 */

		for (HashMap.Entry<Suit, Foundation> foundation : this.foundations.entrySet()) {
			IO.getInstance().write("Palo " + foundation.getKey().toString() + ": ");

			if (foundation.getValue().isEmpty())
				IO.getInstance().writeln("<vacío>");
			else
				IO.getInstance().writeln(foundation.getValue().getFirstCard().toString());
		}

		/**
		 * PRINT PILES
		 */

		for (int pileIndex = 1; pileIndex <= PILES; pileIndex++) {
			IO.getInstance().write("Escalera  " + pileIndex + ": ");

			for (Card card : this.piles.get(pileIndex - 1).getCards()) {
				if (card.isUpturned())
					IO.getInstance().write(card.toString());
				else
					IO.getInstance().write("[");
			}
			
			IO.getInstance().writeln();
		}

		IO.getInstance().writeGameMenu();
	}
}
