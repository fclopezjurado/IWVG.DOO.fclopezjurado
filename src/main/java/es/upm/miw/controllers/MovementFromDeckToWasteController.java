/**
 * 
 */
package es.upm.miw.controllers;

import es.upm.miw.models.Game;

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
		this.getTableau().write();
	}
}
