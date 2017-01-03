/**
 * 
 */
package es.upm.miw.models;

/**
 * @author FCL
 *
 */
public class Pile extends Stack {
	/**
	 * 
	 */
	protected Pile() {
		super();
	}

	/*
	 * @see es.upm.miw.models.Stack#push(es.upm.miw.models.Card)
	 */
	@Override
	protected void push(Card card) {
		assert card != null;
		this.getCards().add(card);
	}
	
	/**
	 * 
	 */
	public void upturnCards() {
		for (Card card : this.getCards())
			if (!card.isUpturned())
				card.turn();
	}
}
