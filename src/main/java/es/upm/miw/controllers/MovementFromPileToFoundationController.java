/**
 * 
 */
package es.upm.miw.controllers;

import es.upm.miw.models.Game;
import es.upm.miw.models.State;
import es.upm.miw.models.Tableau;
import es.upm.miw.utils.Error;
import es.upm.miw.utils.IO;
import es.upm.miw.utils.InputMessage;

/**
 * @author FCL
 *
 */
public class MovementFromPileToFoundationController extends Controller {
	/**
	 * @param game
	 */
	public MovementFromPileToFoundationController(Game game) {
		super(game);
	}

	/**
	 * 
	 */
	@Override
	public void execute() {
		int pileNumber = IO.getInstance().readPileNumber(Tableau.PILES);
		
		if (!this.getTableau().moveFromPileToFoundation(pileNumber))
			IO.getInstance().writeln(Error.INVALID_MOVEMENT_FROM_PILE_TO_FOUNDATION.toString());

		if (this.getTableau().areFoundationsFull()) {
			this.setState(State.FINAL);
			IO.getInstance().writeln(InputMessage.GAME_HAS_BEEN_FINISHED.toString());
		}

		this.getTableau().write();
	}

}
