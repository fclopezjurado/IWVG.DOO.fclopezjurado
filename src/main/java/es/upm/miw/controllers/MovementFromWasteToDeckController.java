/**
 * 
 */
package es.upm.miw.controllers;

import es.upm.miw.models.Game;

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
		this.getTableau().write();
	}

}
