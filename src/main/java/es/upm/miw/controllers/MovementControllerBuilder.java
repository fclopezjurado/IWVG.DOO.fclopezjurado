package es.upm.miw.controllers;

import java.util.ArrayList;

import es.upm.miw.models.Game;

public class MovementControllerBuilder {

	private ArrayList<Controller> movementControllers;

	protected MovementControllerBuilder(Game game) {
		assert game != null;
		this.movementControllers = new ArrayList<Controller>();
		this.movementControllers.add(new MovementFromDeckToWasteController(game));
		this.movementControllers.add(new MovementFromWasteToDeckController(game));
		this.movementControllers.add(new MovementFromWasteToFoundationController(game));
		this.movementControllers.add(new MovementFromWasteToPileController(game));
		this.movementControllers.add(new MovementFromPileToFoundationController(game));
		this.movementControllers.add(new MovementFromPileToPileController(game));
		this.movementControllers.add(new MovementFromFoundationToPileController(game));
		this.movementControllers.add(new TurnController(game));
	}

	protected Controller getMovementController(int controller) {
		assert ((controller > 0) && (controller <= this.movementControllers.size()));
		return this.movementControllers.get(controller - 1);
	}

}
