package es.upm.miw.models;

public class Game extends TableauManager {
	private State state;

	public Game() {
		super();
		this.state = State.INITIAL;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public boolean areFoundationsFull() {
		for (Suit suit : Suit.values())
			if (this.tableau.getFoundation(suit).numberOfCards() < CardNumber.values().length)
				return false;

		return true;
	}

	public boolean moveToWaste() {
		this.moveToDeck();
		boolean successful = this.tableau.moveCards(this.tableau.getDeck(), this.tableau.getWaste(), Waste.SIZE, true);

		if (successful)
			this.tableau.getWaste().upturnCards();

		return successful;
	}

	public boolean moveToDeck() {
		return this.tableau.moveCards(this.tableau.getWaste(), this.tableau.getDeck(),
				this.tableau.getWaste().numberOfCards(), true);
	}

	public boolean moveFromWasteToFoundation() {
		if (!this.tableau.getWaste().isEmpty())
			return this.tableau.moveCards(this.tableau.getWaste(),
					this.tableau.getFoundation(this.tableau.getWaste().getFirstCard().getPip()), 1, true);

		return false;
	}

	public boolean moveFromWasteToPile(int pile) {
		assert ((pile > 0) && (pile <= Tableau.PILES));

		if (!this.tableau.getWaste().isEmpty())
			return this.tableau.moveCards(this.tableau.getWaste(), this.tableau.getPile(pile - 1), 1, true);

		return false;
	}

	public boolean moveFromPileToFoundation(int pile) {
		assert ((pile > 0) && (pile <= Tableau.PILES));

		Pile involvedPile = this.tableau.getPile(pile - 1);

		if (!involvedPile.isEmpty())
			return this.tableau.moveCards(involvedPile,
					this.tableau.getFoundation(involvedPile.getFirstCard().getPip()), 1, true);

		return false;
	}

	public boolean moveFromPileToPile(int origin, int destiny, int cards) {
		assert ((origin > 0) && (origin <= Tableau.PILES));
		assert ((destiny > 0) && (destiny <= Tableau.PILES));
		assert cards > 0;

		Pile originPile = this.tableau.getPile(origin - 1);
		Pile destinyPile = this.tableau.getPile(destiny - 1);
		Pile auxiliarPile = new Pile();

		if (originPile.numberOfUpturnedCards() >= cards) {
			this.tableau.moveCards(originPile, auxiliarPile, cards, false);
			boolean successful = this.tableau.moveCards(auxiliarPile, destinyPile, cards, true);

			if (successful)
				return true;
			else
				this.tableau.moveCards(auxiliarPile, originPile, cards, false);
		}

		return false;
	}

	public boolean moveFromFoundationToPile(int foundation, int destiny) {
		assert ((foundation > 0) && (foundation <= this.numberOfFoundations()));
		assert ((destiny > 0) && (destiny <= this.numberOfPiles()));

		Foundation involvedFoundation = this.tableau.getFoundation(Suit.values()[foundation - 1]);

		if (!involvedFoundation.isEmpty())
			return this.tableau.moveCards(involvedFoundation, this.tableau.getPile(destiny - 1), 1, true);

		return false;
	}

	public boolean turnCard(int pile) {
		assert ((pile > 0) && (pile <= Tableau.PILES));

		Pile involvedPile = this.tableau.getPile(pile - 1);

		if (involvedPile.getFirstCard().isUpturned())
			return false;

		involvedPile.turnFirstCard();
		return true;
	}

}
