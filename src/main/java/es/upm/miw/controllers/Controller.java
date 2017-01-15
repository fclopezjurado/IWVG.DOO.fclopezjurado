package es.upm.miw.controllers;

import es.upm.miw.models.Game;
import es.upm.miw.models.State;

public abstract class Controller implements es.upm.miw.interfaces.Controller {
	private Game game;

	protected Controller(Game game) {
		assert game != null;
		this.game = game;
	}

	protected State getState() {
		return this.game.getState();
	}

	protected void setState(State state) {
		assert state != null;
		this.game.setState(state);
	}

	protected Game getGame() {
		return this.game;
	}

}