
package es.upm.miw.controllers;

import java.util.List;

import es.upm.miw.models.Card;
import es.upm.miw.models.Game;
import es.upm.miw.models.Suit;

public abstract class PresenterController extends Controller implements es.upm.miw.interfaces.PresenterController {
	
	protected PresenterController(Game game) {
		super(game);
	}

	@Override
	public boolean deckIsEmpty() {
		return this.getGame().deckIsEmpty();
	}

	@Override
	public boolean wasteIsEmpty() {
		return this.getGame().wasteIsEmpty();
	}

	@Override
	public List<Card> getWasteCards() {
		return this.getGame().getWasteCards();
	}

	@Override
	public int numberOfFoundations() {
		return this.getGame().numberOfFoundations();
	}

	@Override
	public boolean foundationIsEmpty(int foundation) {
		return this.getGame().foundationIsEmpty(foundation);
	}

	@Override
	public Suit getFoundationSuit(int foundation) {
		return this.getGame().getFoundationSuit(foundation);
	}

	@Override
	public Card getFirstFoundationCard(int foundation) {
		return this.getGame().getFirstFoundationCard(foundation);
	}

	@Override
	public int numberOfPiles() {
		return this.getGame().numberOfPiles();
	}

	@Override
	public List<Card> getPileCards(int pile) {
		return this.getGame().getPileCards(pile);
	}

	@Override
	public boolean cardIsUpturned(int pile, int card) {
		return this.getGame().cardIsUpturned(pile, card);
	}

	@Override
	public int numberOfUpturnedCards(int pile) {
		return this.getGame().numberOfUpturnedCards(pile);
	}

	@Override
	public boolean equalsToFirstCard(int pile, int card) {
		return this.getGame().equalsToFirstCard(pile, card);
	}
}
