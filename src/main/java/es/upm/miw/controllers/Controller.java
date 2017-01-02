/**
 * 
 */
package es.upm.miw.controllers;

import es.upm.miw.models.Game;

/**
 * @author FCL
 *
 */
public abstract class Controller {
	private Game game;

	/**
	 * @param game
	 */
	protected Controller(Game game) {
		assert game != null;
		this.game = game;
	}
	
	/**
	 * @return the game
	 */
	protected Game getGame() {
		return game;
	}

	protected abstract void execute();
}
