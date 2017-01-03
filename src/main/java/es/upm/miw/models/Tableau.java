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
	protected static final int CARDS = 40;
	protected static final int PILES = 7;

	private Deck deck;
	private Pile waste;
	private HashMap<Suit, Pile> foundations;
	private ArrayList<Pile> piles;

	/**
	 * 
	 */
	protected Tableau() {
		this.initDeck();
		this.initFoundations();
		this.initPiles();
	}

	/**
	 * @return the deck
	 */
	protected Deck getDeck() {
		return deck;
	}

	/**
	 * @return the waste
	 */
	protected Pile getWaste() {
		return waste;
	}

	/**
	 * @param pip
	 * @return
	 */
	protected Pile getFoundation(Suit pip) {
		assert pip != null;
		return this.foundations.get(pip);
	}

	/**
	 * @param index
	 * @return
	 */
	protected Pile getPile(int index) {
		assert index > 0;
		return this.piles.get(index);
	}

	/**
	 * 
	 */
	private void initDeck() {
		while (this.deck.numberOfCards() < Tableau.CARDS) {
			Card card = new Card();

			if (!this.deck.isCardInStack(card))
				this.deck.push(card);
		}
	}

	/**
	 * 
	 */
	private void initFoundations() {
		this.foundations = new HashMap<Suit, Pile>();

		for (Suit suit : Suit.values())
			this.foundations.put(suit, new Pile());
	}

	/**
	 * 
	 */
	private void initPiles() {
		for (int numberOfPiles = 1; numberOfPiles <= Tableau.PILES; numberOfPiles++)
			for (int cardsInPile = Tableau.PILES; cardsInPile >= numberOfPiles; cardsInPile--) {
				Pile pile = new Pile();

				if (cardsInPile == Tableau.PILES)
					pile.push(this.deck.pull().turn());
				else
					pile.push(this.deck.pull());
			}
	}

	/**
	 * @return
	 */
	protected boolean areFoundationsFull() {
		for (HashMap.Entry<Suit, Pile> foundation : this.foundations.entrySet())
			if (foundation.getValue().numberOfCards() < CardNumber.values().length)
				return false;

		return true;
	}

	/**
	 * @param origin
	 * @param destiny
	 * @param cards
	 */
	protected void moveCards(Stack origin, Stack destiny, int cards) {
		assert origin != null;
		assert destiny != null;
		assert cards > 0;

		for (int index = 0; index < cards; index++)
			destiny.push(origin.pull());
	}
	
	/**
	 * 
	 */
	public void write() {
		IO.getInstance().writeDoubleHorizontalLine();
		
		/**
		 * PRINT DECK
		 */
		
		IO.getInstance().write("Baraja: ");
		
		if (this.deck.numberOfCards() == 0)
			IO.getInstance().writeln("<vacío>");
		else
			IO.getInstance().writeln("[X,X]");
		
		/**
		 * PRINT WASTE
		 */
		
		IO.getInstance().write("Descarte: ");
		
		if (this.waste.numberOfCards() == 0)
			IO.getInstance().writeln("<vacío>");
		else {
			for (Card card : this.waste.getCards())
					IO.getInstance().write("[" + card.getNumber().toString() + "," + card.getPip().toString() + "]");
			
			IO.getInstance().writeln();
		}
		
		/**
		 * PRINT FOUNDATIONS
		 */
		
		for (HashMap.Entry<Suit, Pile> foundation : this.foundations.entrySet()) {
			IO.getInstance().write("Palo " + foundation.getKey().toString() + ": ");
			
			if (foundation.getValue().numberOfCards() == 0)
				IO.getInstance().writeln("<vacío>");
			else
				IO.getInstance().writeln("[" + foundation.getValue().getFirstCard().getNumber().toString() 
						+ "," + foundation.getValue().getFirstCard().getPip().toString());
		}
		
		/**
		 * PRINT PILES
		 */
		
		for (int pileIndex = 1; pileIndex <= Tableau.PILES; pileIndex++) {
			IO.getInstance().write("Escalera  " + pileIndex + ": ");
			
			for (Card card : this.piles.get(pileIndex - 1).getCards()) {
				if (card.isUpturned())
					IO.getInstance().writeln("[" + card.getNumber().toString() + "," + card.getPip().toString() + "]");
				else
					IO.getInstance().write("[");
			}
		}
			
	}
}
