/**
 * 
 */
package es.upm.miw.models;

/**
 * @author FCL
 *
 */
public class Deck extends Stack {
	/**
	 * 
	 */
	protected Deck() {
		super();
	}

	/**
	 * 
	 */
	@Override
	protected void push(Card card) {
		this.getCards().add(0, card);
	}
}
