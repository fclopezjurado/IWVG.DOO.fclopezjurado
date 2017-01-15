package es.upm.miw.controllers;

import es.upm.miw.models.Game;

public class Logic {
	private Game game;
	private StartController startController;
	private MovementControllerBuilder movementControllerBuilder;
	private MenuController menuController;

	public Logic() {
		this.game = new Game();
		this.startController = new StartController(this.game);
		this.movementControllerBuilder = new MovementControllerBuilder(this.game);
		this.menuController = new MenuController(this.game);
	}

	public Controller getController() {
		switch (game.getState()) {
		case INITIAL:
			return this.startController;
		case GET_OPTION:
			return this.menuController;
		case IN_GAME:
			return this.movementControllerBuilder.getMovementController(this.menuController.getOption());
		case FINAL:
		default:
			return null;
		}
	}

}
