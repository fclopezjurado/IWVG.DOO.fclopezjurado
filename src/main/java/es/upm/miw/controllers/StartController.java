package es.upm.miw.controllers;

import es.upm.miw.interfaces.ControllerVisitor;
import es.upm.miw.interfaces.MovementControllerVisitor;
import es.upm.miw.models.Game;
import es.upm.miw.models.State;

public class StartController extends PresenterController implements es.upm.miw.interfaces.StartController {

	public StartController(Game game) {
		super(game);
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
	}

	@Override
	public void start() {
		assert this.getState() == State.INITIAL;
		this.setState(State.GET_OPTION);
	}

	@Override
	public void accept(MovementControllerVisitor movementControllerVisitor) {
	}
}
