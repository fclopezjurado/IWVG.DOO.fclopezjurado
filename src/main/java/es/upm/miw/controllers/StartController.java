/**
 * 
 */
package es.upm.miw.controllers;

import es.upm.miw.models.Game;
import es.upm.miw.models.State;

/**
 * @author FCL
 *
 */
public class StartController extends Controller {
	/**
	 * @param game
	 */
	public StartController(Game game) {
		super(game);
	}

	/**
	 * 
	 */
	@Override
	public void execute() {
		assert this.getState() == State.INITIAL;
		this.getTableau().write();
		this.setState(State.IN_GAME);
	}
}
