package es.upm.miw.controllers;

import es.upm.miw.interfaces.ControllerVisitor;
import es.upm.miw.interfaces.MovementControllerVisitor;
import es.upm.miw.interfaces.MovementToUnknownDestinyController;
import es.upm.miw.models.Game;
import es.upm.miw.models.State;

public class TurnController extends PresenterController implements MovementToUnknownDestinyController {

	protected TurnController(Game game) {
		super(game);
	}

	@Override
	public boolean move(int destiny) {
		this.setState(State.GET_OPTION);
		return this.getGame().turnCard(destiny);
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
