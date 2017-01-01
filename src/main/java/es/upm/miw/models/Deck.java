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
	public Deck() {
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
