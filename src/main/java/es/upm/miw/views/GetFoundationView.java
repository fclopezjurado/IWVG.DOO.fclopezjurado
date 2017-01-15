package es.upm.miw.views;

import es.upm.miw.utils.IO;

public class GetFoundationView {

	protected GetFoundationView() {
	}

	protected int getFoundation(int foundations) {
		int foundationNumber = 0;

		while (foundationNumber == 0) {
			foundationNumber = IO.getInstance().readInt(InputMessage.GET_FOUNDATION + "[1," + foundations + "]: ");

			if ((foundationNumber > 0) && (foundationNumber <= foundations))
				return foundationNumber;
			else {
				IO.getInstance().writeln(Error.INVALID_SUIT.toString());
				foundationNumber = 0;
			}
		}

		return foundationNumber;
	}

}
