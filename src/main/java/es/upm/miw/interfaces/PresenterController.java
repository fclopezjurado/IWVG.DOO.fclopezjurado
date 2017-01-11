package es.upm.miw.interfaces;

import es.upm.miw.models.Card;
import es.upm.miw.models.Pile;
import es.upm.miw.models.Suit;
import es.upm.miw.models.Waste;

public interface PresenterController {

	public boolean deckIsEmpty();

	public boolean wasteIsEmpty();

	public Waste getWaste();

	public int numberOfFoundations();

	public boolean foundationIsEmpty(Suit suit);

	public Suit getFoundationSuit(int foundation);

	public Card getFirstFoundationCard(int foundation);

	public int numberOfPiles();

	public Pile getPile(int pile);

}
