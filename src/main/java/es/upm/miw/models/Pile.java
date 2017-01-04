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
	 * @param card
	 * @return
	 */
	protected boolean isStackable(Card card) {
		return ((this.isEmpty() && (card.getNumber() == CardNumber.KING)) || (!this.isEmpty() 
				&& (this.getFirstCard().getPip() != card.getPip()) 
				&& (this.getFirstCard().getNumber().ordinal() == (card.getNumber().ordinal() + 1))));
	}
	
	/**
	 * 
	 */
	protected void turnFirstCard() {
		if (!this.isEmpty())
			this.getFirstCard().turn();
	}
	
	/**
	 * @return
	 */
	protected int numberOfUpturnedCards() {
		int numberOfUpturnedCards = 0;
		
		for (Card card : this.getCards())
			if (card.isUpturned())
				numberOfUpturnedCards++;
		
		return numberOfUpturnedCards;
	}
}
