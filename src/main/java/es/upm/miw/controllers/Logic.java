/**
 * 
 */
package es.upm.miw.controllers;

import java.util.ArrayList;

import es.upm.miw.models.Game;
import es.upm.miw.utils.IO;
import es.upm.miw.utils.InputMessage;

/**
 * @author FCL
 *
 */
public class Logic {
	private Game game;
	private StartController startController;
	private ArrayList<Controller> movementControllers;

	public Logic() {
		this.game = new Game();
		this.startController = new StartController(this.game);
		this.initMovementControllers();
	}

	private void initMovementControllers() {
		this.movementControllers = new ArrayList<Controller>();
		this.movementControllers.add(new MovementFromDeckToWasteController(this.game));
		this.movementControllers.add(new MovementFromWasteToDeckController(this.game));
		this.movementControllers.add(new MovementFromWasteToFoundationController(this.game));
		this.movementControllers.add(new MovementFromWasteToPileController(this.game));
		this.movementControllers.add(new MovementFromPileToFoundationController(this.game));
		this.movementControllers.add(new MovementFromPileToPileController(this.game));
		this.movementControllers.add(new MovementFromFoundationToPileController(this.game));
		this.movementControllers.add(new TurnController(this.game));
	}

	private Controller getMovementController() {
		int movementControllerIndex = IO.getInstance().readMenuOption();

		if (movementControllerIndex > this.movementControllers.size()) {
			IO.getInstance().writeln(InputMessage.EXIT.toString());
			return null;
		}

		return this.movementControllers.get(movementControllerIndex - 1);
	}

	public Controller getController() {
		switch (game.getState()) {
		case INITIAL:
			return this.startController;
		case IN_GAME:
			return this.getMovementController();
		case FINAL:
		default:
			return null;
		}
	}
}
