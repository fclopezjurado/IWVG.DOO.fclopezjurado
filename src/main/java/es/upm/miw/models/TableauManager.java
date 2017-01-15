package es.upm.miw.models;

import java.util.List;

public abstract class TableauManager {

	protected Tableau tableau;

	protected TableauManager() {
		this.tableau = new Tableau();
	}

	public boolean deckIsEmpty() {
		return this.tableau.getDeck().isEmpty();
	}

	public boolean wasteIsEmpty() {
		return this.tableau.getWaste().isEmpty();
	}

	public List<Card> getWasteCards() {
		assert !this.wasteIsEmpty();
		return this.tableau.getWaste().getCards();
	}

	public int numberOfFoundations() {
		return Tableau.FOUNDATIONS;
	}

	public boolean foundationIsEmpty(int foundation) {
		assert ((foundation > 0) && (foundation <= this.numberOfFoundations()));
		return this.tableau.getFoundation(Suit.values()[foundation - 1]).isEmpty();
	}

	public Suit getFoundationSuit(int foundation) {
		assert ((foundation > 0) && (foundation <= this.numberOfFoundations()));
		return Suit.values()[foundation - 1];
	}

	public Card getFirstFoundationCard(int foundation) {
		assert ((foundation > 0) && (foundation <= this.numberOfFoundations()));
		assert !this.foundationIsEmpty(foundation);
		return this.tableau.getFoundation(Suit.values()[foundation - 1]).getFirstCard();
	}

	public int numberOfPiles() {
		return Tableau.PILES;
	}

	public List<Card> getPileCards(int pile) {
		assert ((pile > 0) && (pile <= this.numberOfPiles()));
		return this.tableau.getPile(pile).getCards();
	}

	public boolean cardIsUpturned(int pile, int card) {
		assert ((pile > 0) && (pile <= this.numberOfPiles()));
		assert !this.tableau.getPile(pile).isEmpty();
		assert ((card > 0) && (card <= this.tableau.getPile(pile).numberOfCards()));
		return this.tableau.getPile(pile).getCards().get(card).isUpturned();
	}

	public int numberOfUpturnedCards(int pile) {
		assert ((pile > 0) && (pile <= this.numberOfPiles()));
		return this.tableau.getPile(pile).numberOfUpturnedCards();
	}

	public boolean equalsToFirstCard(int pile, int card) {
		assert ((pile > 0) && (pile <= this.numberOfPiles()));
		assert !this.tableau.getPile(pile).isEmpty();
		assert ((card > 0) && (card <= this.tableau.getPile(pile).numberOfCards()));
		return this.tableau.getPile(pile).getCards().get(card).equals(this.tableau.getPile(pile).getFirstCard());
	}

}
