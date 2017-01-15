package es.upm.miw.models;

import java.util.ArrayList;
import java.util.HashMap;

public class Tableau {
	public static final int PILES = 7;
	public static final int FOUNDATIONS = Suit.values().length;

	private Deck deck;
	private Waste waste;
	private HashMap<Suit, Foundation> foundations;
	private ArrayList<Pile> piles;

	protected Tableau() {
		this.deck = new Deck();
		this.waste = new Waste();
		this.foundations = new HashMap<Suit, Foundation>();
		this.piles = new ArrayList<Pile>();

		this.initDeck();
		this.initFoundations();
		this.initPiles();
	}

	protected Deck getDeck() {
		return this.deck;
	}

	protected Waste getWaste() {
		return this.waste;
	}

	protected Foundation getFoundation(Suit suit) {
		return this.foundations.get(suit);
	}

	protected Pile getPile(int index) {
		assert ((index > 0) && (index < PILES));
		return this.piles.get(index);
	}

	private void initDeck() {
		while (this.deck.numberOfCards() < Deck.SIZE) {
			Card card = new Card();

			if (this.deck.isStackable(card))
				this.deck.push(card);
		}
	}

	private void initFoundations() {
		for (Suit suit : Suit.values())
			this.foundations.put(suit, new Foundation());
	}

	private void initPiles() {
		for (int numberOfPiles = 0; numberOfPiles < PILES; numberOfPiles++) {
			Pile pile = new Pile();
			this.moveCards(this.deck, pile, PILES - numberOfPiles, false);
			pile.turnFirstCard();
			this.piles.add(pile);
		}
	}

	protected boolean moveCards(Stack origin, Stack destiny, int cards, boolean check) {
		assert origin != null;
		assert destiny != null;
		assert cards > 0;

		if (origin.numberOfCards() >= cards) {
			for (int index = 0; index < cards; index++) {
				if (!check || (check && destiny.isStackable(origin.getFirstCard())))
					destiny.push(origin.pull());
				else
					return false;
			}

			return true;
		}

		return false;
	}

}
