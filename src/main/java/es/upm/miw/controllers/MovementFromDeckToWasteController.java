/**
 * 
 */
package es.upm.miw.controllers;

import es.upm.miw.models.Game;
import es.upm.miw.models.State;
import es.upm.miw.utils.IO;
import es.upm.miw.utils.InputMessage;

/**
 * @author FCL
 *
 */
public class MovementFromDeckToWasteController extends Controller {
	/**
	 * @param game
	 */
	public MovementFromDeckToWasteController(Game game) {
		super(game);
	}

	/**
	 * 
	 */
	@Override
	public void execute() {
		this.getTableau().moveToWaste();

		if (this.getTableau().areFoundationsFull()) {
			this.setState(State.FINAL);
			IO.getInstance().writeln(InputMessage.GAME_HAS_BEEN_FINISHED.toString());
		}

		this.getTableau().write();
	}
}
