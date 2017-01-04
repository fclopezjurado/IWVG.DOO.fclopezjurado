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
	protected Card getFirstCard() {
		return this.cards.get(this.numberOfCards() - 1);
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
	protected Card pull() {
		assert this.numberOfCards() > 0;

		Card card = this.cards.get(this.numberOfCards() - 1);
		this.cards.remove(card);

		return card;
	}
	
	/**
	 * @return
	 */
	protected boolean isEmpty() {
		return this.cards.isEmpty();
	}

	/**
	 * @param card
	 */
	protected abstract void push(Card card);
	
	/**
	 * @param card
	 * @return
	 */
	protected abstract boolean isStackable(Card card);
}
