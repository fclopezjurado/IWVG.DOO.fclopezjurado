package es.upm.miw.models;

public class Waste extends Stack {

	protected static final int SIZE = 3;

	protected Waste() {
		super();
	}

	@Override
	protected void push(Card card) {
		assert card != null;
		this.getCards().add(card);
	}

	protected void upturnCards() {
		for (Card card : this.getCards())
			if (!card.isUpturned())
				card.turn();
	}

	@Override
	protected boolean isStackable(Card card) {
		return true;
	}

}
