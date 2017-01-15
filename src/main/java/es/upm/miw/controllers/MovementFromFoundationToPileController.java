package es.upm.miw.controllers;

import es.upm.miw.interfaces.ControllerVisitor;
import es.upm.miw.interfaces.MovementControllerVisitor;
import es.upm.miw.interfaces.MovementFromOriginToDestinyController;
import es.upm.miw.models.Game;
import es.upm.miw.models.State;

public class MovementFromFoundationToPileController extends PresenterController
		implements MovementFromOriginToDestinyController {

	public MovementFromFoundationToPileController(Game game) {
		super(game);
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
	}

	@Override
	public boolean move(int origin, int destiny) {
		this.setState(State.GET_OPTION);
		return this.getGame().moveFromFoundationToPile(origin, destiny);
	}
	
	@Override
	public void accept(MovementControllerVisitor movementControllerVisitor) {
		movementControllerVisitor.visit(this);
	}

}
