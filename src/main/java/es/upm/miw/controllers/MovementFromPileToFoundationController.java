package es.upm.miw.controllers;

import es.upm.miw.interfaces.ControllerVisitor;
import es.upm.miw.interfaces.MovementControllerVisitor;
import es.upm.miw.interfaces.SmartMovementToUnknownDestinyController;
import es.upm.miw.models.Game;
import es.upm.miw.models.State;

public class MovementFromPileToFoundationController extends PresenterController
		implements SmartMovementToUnknownDestinyController {

	public MovementFromPileToFoundationController(Game game) {
		super(game);
	}

	@Override
	public boolean move(int destiny) {
		this.setState(State.GET_OPTION);
		return this.getGame().moveFromPileToFoundation(destiny);
	}

	@Override
	public boolean playerHasWon() {
		return this.getGame().areFoundationsFull();
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
	}
	
	@Override
	public void accept(MovementControllerVisitor movementControllerVisitor) {
		movementControllerVisitor.visit(this);
	}

}
