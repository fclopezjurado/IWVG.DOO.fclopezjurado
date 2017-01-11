/**
 * 
 */
package es.upm.miw.views;

import es.upm.miw.interfaces.MovementController;
import es.upm.miw.utils.Error;
import es.upm.miw.utils.IO;
import es.upm.miw.utils.InputMessage;

/**
 * @author FCL
 *
 */
public class GameView {

	protected void interact(MovementController movementController) {
	}

	private int getNumberOfCards() {
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

	private int getPileNumber(int piles) {
		int pileNumber = 0;

		while (pileNumber == 0) {
			pileNumber = IO.getInstance().readInt(InputMessage.PILE_NUMBER + "[1," + piles + "]: ");

			if ((pileNumber > 0) && (pileNumber <= piles))
				return pileNumber;
			else {
				IO.getInstance().writeln(Error.INVALID_PILE_NUMBER.toString());
				pileNumber = 0;
			}
		}

		return pileNumber;
	}

	private int getFoundation(int suits) {
		int foundationNumber = 0;

		while (foundationNumber == 0) {
			foundationNumber = IO.getInstance().readInt(InputMessage.GET_FOUNDATION + "[1," + suits + "]: ");

			if ((foundationNumber > 0) && (foundationNumber <= suits))
				return foundationNumber;
			else {
				IO.getInstance().writeln(Error.INVALID_SUIT.toString());
				foundationNumber = 0;
			}
		}

		return foundationNumber;
	}

}
