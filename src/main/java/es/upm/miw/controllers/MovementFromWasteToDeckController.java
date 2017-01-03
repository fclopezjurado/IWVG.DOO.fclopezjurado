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
public class MovementFromWasteToDeckController extends Controller {
	/**
	 * @param game
	 */
	public MovementFromWasteToDeckController(Game game) {
		super(game);
	}

	/**
	 * 
	 */
	@Override
	public void execute() {
		this.getTableau().moveToDeck();

		if (this.getTableau().areFoundationsFull()) {
			this.setState(State.FINAL);
			IO.getInstance().writeln(InputMessage.GAME_HAS_BEEN_FINISHED.toString());
		}

		this.getTableau().write();
	}

}
