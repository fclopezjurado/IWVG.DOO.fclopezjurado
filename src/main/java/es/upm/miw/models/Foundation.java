/**
 * 
 */
package es.upm.miw.models;

/**
 * @author FCL
 *
 */
public class Foundation extends Stack {
	/**
	 * 
	 */
	protected Foundation() {
		super();
	}

	/**
	 * @see es.upm.miw.models.Stack#push(es.upm.miw.models.Card)
	 */
	@Override
	protected void push(Card card) {
		assert card != null;
		this.getCards().add(card);
	}

	/**
	 * @param card
	 * @return
	 */
	protected boolean isStackable(Card card) {
		return ((this.isEmpty() && (card.getNumber() == CardNumber.ONE)) || (!this.isEmpty() 
				&& (this.getFirstCard().getPip() == card.getPip()) 
				&& (this.getFirstCard().getNumber().ordinal() == (card.getNumber().ordinal() + 1))));
	}
}
