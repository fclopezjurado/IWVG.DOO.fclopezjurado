package es.upm.miw.models;

public class Foundation extends Stack {

	protected Foundation() {
		super();
	}

	@Override
	protected void push(Card card) {
		assert card != null;
		this.getCards().add(card);
	}

	protected boolean isStackable(Card card) {
		return ((this.isEmpty() && (card.getNumber() == CardNumber.ONE))
				|| (!this.isEmpty() && (this.getFirstCard().getPip() == card.getPip())
						&& ((this.getFirstCard().getNumber().ordinal() + 1) == card.getNumber().ordinal())));
	}

}
