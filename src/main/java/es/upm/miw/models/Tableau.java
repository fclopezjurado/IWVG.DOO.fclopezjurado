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
	 * @param suit
	 * @return
	 */
	private Foundation getFoundation(Suit suit) {
		return this.foundations.get(suit);
	}

	/**
	 * 
	 */
	private void initDeck() {
		while (this.deck.numberOfCards() < Deck.SIZE) {
			Card card = new Card();

			if (this.deck.isStackable(card))
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

			for (int cardsInPile = PILES; cardsInPile >= numberOfPiles; cardsInPile--)
				pile.push(this.deck.pull());
			
			pile.turnFirstCard();
			this.piles.add(pile);
		}
	}

	/**
	 * @return
	 */
	public boolean areFoundationsFull() {
		for (Suit suit: Suit.values())
			if (this.getFoundation(suit).numberOfCards() < CardNumber.values().length)
				return false;

		return true;
	}
	
	/**
	 * @param origin
	 * @param destiny
	 * @param cards
	 * @return
	 */
	private boolean moveCards(Stack origin, Stack destiny, int cards) {
		assert origin != null;
		assert destiny != null;
		assert cards > 0;
		
		if (origin.numberOfCards() >= cards) {
			for (int index = 0; index < cards; index++) {
				if (destiny.isStackable(origin.getFirstCard()))
					destiny.push(origin.pull());
				else
					return false;
			}
				
			return true;
		}
		
		return false;
	}

	/**
	 * 
	 */
	public boolean moveToWaste() {
		this.moveToDeck();
		boolean successful = this.moveCards(this.deck, this.waste, Waste.SIZE);
		
		if (successful)
			this.waste.upturnCards();
		
		return successful;
	}

	/**
	 * 
	 */
	public boolean moveToDeck() {
		return this.moveCards(this.waste, this.deck, Waste.SIZE);
	}

	/**
	 * 
	 */
	public boolean moveFromWasteToFoundation() {
		if (!this.waste.isEmpty())
			return this.moveCards(this.waste, this.getFoundation(this.waste.getFirstCard().getPip()), 1);

		return false;
	}

	/**
	 * @param numberOfPile
	 * @return
	 */
	public boolean moveFromWasteToPile(int numberOfPile) {
		assert ((numberOfPile > 0) && (numberOfPile <= PILES));
		
		if (!this.waste.isEmpty())
			return this.moveCards(this.waste, this.piles.get(numberOfPile - 1), 1);

		return false;
	}
	
	/**
	 * @param numberOfPile
	 * @return
	 */
	public boolean moveFromPileToFoundation(int numberOfPile) {
		assert ((numberOfPile > 0) && (numberOfPile <= PILES));
		
		Pile involvedPile = this.piles.get(numberOfPile - 1);
		
		if (!involvedPile.isEmpty())
			return this.moveCards(involvedPile, this.getFoundation(involvedPile.getFirstCard().getPip()), 1);

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
		else
			for (Card card : this.waste.getCards()) {
				if (card.equals(this.waste.getFirstCard()))
					IO.getInstance().writeln(card.toString());
				else
					IO.getInstance().write(card.toString());
			}

		/**
		 * PRINT FOUNDATIONS
		 */

		for (Suit suit : Suit.values()) {
			IO.getInstance().write("Palo " + suit.toString() + ": ");
			
			if (this.getFoundation(suit).isEmpty())
				IO.getInstance().writeln("<vacío>");
			else
				IO.getInstance().writeln(this.getFoundation(suit).getFirstCard().toString());
		}

		/**
		 * PRINT PILES
		 */

		for (int pileIndex = 1; pileIndex <= PILES; pileIndex++) {
			IO.getInstance().write("Escalera  " + pileIndex + ": ");
			
			for (Card card : this.piles.get(pileIndex - 1).getCards()) {
				if (card.equals(this.piles.get(pileIndex - 1).getFirstCard()) && card.isUpturned())
					IO.getInstance().writeln(card.toString());
				else if (card.equals(this.piles.get(pileIndex - 1).getFirstCard()))
					IO.getInstance().writeln("[X,X]");
				else
					IO.getInstance().write("[");
			}
		}

		IO.getInstance().writeGameMenu();
	}
}
