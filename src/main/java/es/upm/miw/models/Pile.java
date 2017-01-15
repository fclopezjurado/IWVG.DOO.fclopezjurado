package es.upm.miw.models;

public class Pile extends Stack {

	protected Pile() {
		super();
	}

	@Override
	protected void push(Card card) {
		assert card != null;
		this.getCards().add(card);
	}

	protected boolean isStackable(Card card) {
		return ((this.isEmpty() && (card.getNumber() == CardNumber.KING))
				|| (!this.isEmpty() && (this.getFirstCard().getPip() != card.getPip())
						&& (this.getFirstCard().getNumber().ordinal() == (card.getNumber().ordinal() + 1))));
	}

	protected void turnFirstCard() {
		if (!this.isEmpty())
			this.getFirstCard().turn();
	}

	protected int numberOfUpturnedCards() {
		int numberOfUpturnedCards = 0;

		for (Card card : this.getCards())
			if (card.isUpturned())
				numberOfUpturnedCards++;

		return numberOfUpturnedCards;
	}

}
