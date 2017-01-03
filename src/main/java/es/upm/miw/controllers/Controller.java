/**
 * 
 */
package es.upm.miw.controllers;

import es.upm.miw.models.Game;
import es.upm.miw.models.State;
import es.upm.miw.models.Tableau;

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
	 * @return
	 */
	protected Tableau getTableau() {
		return this.game.getTableau();
	}
	
	/**
	 * @return
	 */
	protected State getState() {
		return this.game.getState();
	}
	
	/**
	 * @param state
	 */
	protected void setState(State state) {
		assert state != null;
		this.game.setState(state);
	}

	public abstract void execute();
}
