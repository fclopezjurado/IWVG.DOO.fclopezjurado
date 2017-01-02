/**
 * 
 */
package es.upm.miw.models;

import java.util.ArrayList;

/**
 * @author FCL
 *
 */
public abstract class Stack {
	private ArrayList<Card> cards;

	/**
	 * 
	 */
	protected Stack() {
		this.cards = new ArrayList<Card>();
	}

	/**
	 * @return the cards
	 */
	protected ArrayList<Card> getCards() {
		return cards;
	}

	/**
	 * @return
	 */
	protected int numberOfCards() {
		return this.cards.size();
	}

	/**
	 * @return
	 */
	protected int numberOfUpturnedCards() {
		int numberOfUpturnedCards = 0;

		for (Card card : this.cards)
			if (card.isUpturned())
				numberOfUpturnedCards++;

		return numberOfUpturnedCards;
	}

	/**
	 * @return
	 */
	protected Card pull() {
		assert this.numberOfCards() > 0;

		Card card = this.cards.get(this.numberOfCards() - 1);
		this.cards.remove(card);

		return card;
	}

	/**
	 * @param card
	 */
	protected abstract void push(Card card);

	/**
	 * 
	 */
	protected void turnFirstCard() {
		assert this.numberOfCards() > 0;

		this.cards.get(this.numberOfCards() - 1).turn();
	}
	
	/**
	 * @param card
	 * @return
	 */
	protected boolean isCardInStack(Card card) {
		if (this.numberOfCards() > 0)
			for (Card cardInDeck : this.getCards())
				if (cardInDeck.equals(card))
					return true;
		
		return false;
	}
}
