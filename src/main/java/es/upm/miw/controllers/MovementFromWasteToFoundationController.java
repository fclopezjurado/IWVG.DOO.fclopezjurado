/**
 * 
 */
package es.upm.miw.controllers;

import es.upm.miw.models.Game;
import es.upm.miw.models.State;
import es.upm.miw.utils.IO;
import es.upm.miw.utils.InputMessage;
import es.upm.miw.utils.Error;

/**
 * @author FCL
 *
 */
public class MovementFromWasteToFoundationController extends Controller {
	/**
	 * 
	 * @param game
	 */
	public MovementFromWasteToFoundationController(Game game) {
		super(game);
	}

	/**
	 * 
	 */
	@Override
	public void execute() {
		if (!this.getTableau().moveFromWasteToFoundation())
			IO.getInstance().writeln(Error.INVALID_MOVEMENT_FROM_WASTE_TO_FOUNDATION.toString());

		if (this.getTableau().areFoundationsFull()) {
			this.setState(State.FINAL);
			IO.getInstance().writeln(InputMessage.GAME_HAS_BEEN_FINISHED.toString());
		}
		else
			this.getTableau().write();
	}

}
