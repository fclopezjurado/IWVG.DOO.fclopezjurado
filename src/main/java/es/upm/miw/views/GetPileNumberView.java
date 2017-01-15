package es.upm.miw.views;

import es.upm.miw.utils.IO;

public class GetPileNumberView {

	protected GetPileNumberView() {
	}

	protected int getPileNumber(int piles) {
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

}
