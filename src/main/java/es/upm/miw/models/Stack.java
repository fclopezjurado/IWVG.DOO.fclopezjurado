package es.upm.miw.models;

import java.util.ArrayList;

public abstract class Stack {

	private ArrayList<Card> cards;

	protected Stack() {
		this.cards = new ArrayList<Card>();
	}

	protected ArrayList<Card> getCards() {
		return cards;
	}

	protected Card getFirstCard() {
		return this.cards.get(this.numberOfCards() - 1);
	}

	protected int numberOfCards() {
		return this.cards.size();
	}

	protected Card pull() {
		assert this.numberOfCards() > 0;

		Card card = this.cards.get(this.numberOfCards() - 1);
		this.cards.remove(card);

		return card;
	}

	protected boolean isEmpty() {
		return this.cards.isEmpty();
	}

	protected abstract void push(Card card);

	protected abstract boolean isStackable(Card card);

}
