package es.upm.miw.controllers;

import es.upm.miw.interfaces.ControllerVisitor;
import es.upm.miw.interfaces.MovementControllerVisitor;
import es.upm.miw.interfaces.SmartMovementToKnownDestinyController;
import es.upm.miw.models.Game;
import es.upm.miw.models.State;

public class MovementFromWasteToFoundationController extends PresenterController
		implements SmartMovementToKnownDestinyController {

	public MovementFromWasteToFoundationController(Game game) {
		super(game);
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
	}
	
	@Override
	public void accept(MovementControllerVisitor movementControllerVisitor) {
		movementControllerVisitor.visit(this);
	}

	@Override
	public boolean move() {
		this.setState(State.GET_OPTION);
		return this.getGame().moveFromWasteToFoundation();
	}

	@Override
	public boolean playerHasWon() {
		return this.getGame().areFoundationsFull();
	}

}
