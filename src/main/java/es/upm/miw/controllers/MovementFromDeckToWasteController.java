/**
 * 
 */
package es.upm.miw.controllers;

import es.upm.miw.models.Game;
import es.upm.miw.models.State;
import es.upm.miw.utils.IO;

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
			IO.getInstance().writeVictory();
		}

		this.getTableau().write();
	}
}
