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
	public static final int FOUNDATIONS = Suit.values().length;

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
	 * @param index
	 * @return
	 */
	private Pile getPile(int index) {
		assert ((index > 0) && (index < PILES));
		return this.piles.get(index);
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
		for (int numberOfPiles = 0; numberOfPiles < PILES; numberOfPiles++) {
			Pile pile = new Pile();
			this.moveCards(this.deck, pile, PILES - numberOfPiles, false);
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
	 * @param check
	 * @return
	 */
	private boolean moveCards(Stack origin, Stack destiny, int cards, boolean check) {
		assert origin != null;
		assert destiny != null;
		assert cards > 0;
		
		if (origin.numberOfCards() >= cards) {
			for (int index = 0; index < cards; index++) {
				if (!check || (check && destiny.isStackable(origin.getFirstCard())))
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
		boolean successful = this.moveCards(this.deck, this.waste, Waste.SIZE, true);
		
		if (successful)
			this.waste.upturnCards();
		
		return successful;
	}

	/**
	 * 
	 */
	public boolean moveToDeck() {
		return this.moveCards(this.waste, this.deck, this.waste.numberOfCards(), true);
	}

	/**
	 * 
	 */
	public boolean moveFromWasteToFoundation() {
		if (!this.waste.isEmpty())
			return this.moveCards(this.waste, this.getFoundation(this.waste.getFirstCard().getPip()), 1, true);

		return false;
	}

	/**
	 * @param numberOfPile
	 * @return
	 */
	public boolean moveFromWasteToPile(int numberOfPile) {
		assert ((numberOfPile > 0) && (numberOfPile <= PILES));
		
		if (!this.waste.isEmpty())
			return this.moveCards(this.waste, this.getPile(numberOfPile - 1), 1, true);

		return false;
	}
	
	/**
	 * @param numberOfPile
	 * @return
	 */
	public boolean moveFromPileToFoundation(int numberOfPile) {
		assert ((numberOfPile > 0) && (numberOfPile <= PILES));
		
		Pile involvedPile = this.getPile(numberOfPile - 1);
		
		if (!involvedPile.isEmpty())
			return this.moveCards(involvedPile, this.getFoundation(involvedPile.getFirstCard().getPip()), 1, true);

		return false;
	}
	
	/**
	 * @param numberOfPile
	 * @return
	 */
	public boolean turnCardInPile(int numberOfPile) {
		assert ((numberOfPile > 0) && (numberOfPile <= PILES));
		
		Pile involvedPile = this.getPile(numberOfPile - 1);
		
		if (involvedPile.getFirstCard().isUpturned())
			return false;
		
		involvedPile.turnFirstCard();
		return true;
	}
	
	/**
	 * @param origin
	 * @param destiny
	 * @param cards
	 * @return
	 */
	public boolean moveFromPileToPile(int origin, int destiny, int cards) {
		assert ((origin > 0) && (origin <= PILES));
		assert ((destiny > 0) && (destiny <= PILES));
		assert cards > 0;
		
		Pile originPile = this.getPile(origin - 1);
		Pile destinyPile = this.getPile(destiny - 1);
		Pile auxiliarPile = new Pile();
		
		if (originPile.numberOfUpturnedCards() >= cards) {
			this.moveCards(originPile, auxiliarPile, cards, false);
			boolean successful = this.moveCards(auxiliarPile, destinyPile, cards, true);
			
			if (successful)
				return true;
			else
				this.moveCards(auxiliarPile, originPile, cards, false);
		}
		
		return false;
	}
	
	/**
	 * @param numberOfPile
	 * @return
	 */
	public boolean moveFromFoundationToPile(int foundation, int destiny) {
		assert ((foundation > 0) && (foundation <= FOUNDATIONS));
		assert ((destiny > 0) && (destiny <= PILES));
		
		Foundation involvedFoundation = this.foundations.get(Suit.values()[foundation - 1]);
		
		if (!involvedFoundation.isEmpty())
			return this.moveCards(involvedFoundation, this.getPile(destiny - 1), 1, true);

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
		
		for (Pile pile : this.piles) {
			IO.getInstance().write("Escalera " + (this.piles.indexOf(pile) + 1) + ": ");
			
			for (Card card : pile.getCards()) {
				if (card.isUpturned())
					IO.getInstance().write(card.toString());
				else if ((pile.numberOfUpturnedCards() == 0) && card.equals(pile.getFirstCard()))
					IO.getInstance().write("[X,X]");
				else
					IO.getInstance().write("[");
			}
			
			IO.getInstance().writeln();
		}

		IO.getInstance().writeGameMenu();
	}
}
