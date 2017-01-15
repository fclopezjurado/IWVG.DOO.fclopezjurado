package es.upm.miw.views;

import es.upm.miw.utils.IO;

public class GetNumberOfCardsView {

	protected GetNumberOfCardsView() {
	}

	protected int getNumberOfCards() {
		int numberOfCards = 0;

		while (numberOfCards == 0) {
			numberOfCards = IO.getInstance().readInt(InputMessage.NUMBER_OF_CARDS_TO_MOVE.toString());

			if (numberOfCards > 0)
				return numberOfCards;
			else {
				IO.getInstance().writeln(Error.INVALID_NUMBER_OF_CARD_TO_MOVE.toString());
				numberOfCards = 0;
			}
		}

		return numberOfCards;
	}

}
