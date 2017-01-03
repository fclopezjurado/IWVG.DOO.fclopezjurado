/**
 * 
 */
package es.upm.miw.models;

/**
 * @author FCL
 *
 */
public class Deck extends Stack {
	protected static final int SIZE = 40;
		
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
	
	/**
	 * 
	 */
	protected boolean isStackable(Card card) {
		if (this.numberOfCards() > 0)
			for (Card cardInDeck : this.getCards())
				if (cardInDeck.equals(card))
					return true;
		
		return false;
	}
}
