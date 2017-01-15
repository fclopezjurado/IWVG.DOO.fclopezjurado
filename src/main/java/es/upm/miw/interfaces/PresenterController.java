package es.upm.miw.interfaces;

import java.util.List;

import es.upm.miw.models.Card;
import es.upm.miw.models.Suit;

public interface PresenterController {

	public boolean deckIsEmpty();

	public boolean wasteIsEmpty();

	public List<Card> getWasteCards();

	public int numberOfFoundations();

	public boolean foundationIsEmpty(int foundation);

	public Suit getFoundationSuit(int foundation);

	public Card getFirstFoundationCard(int foundation);

	public int numberOfPiles();

	public List<Card> getPileCards(int pile);

	public boolean cardIsUpturned(int pile, int card);

	public int numberOfUpturnedCards(int pile);

	public boolean equalsToFirstCard(int pile, int card);

}
