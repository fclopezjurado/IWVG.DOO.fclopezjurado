package es.upm.miw.controllers;

import es.upm.miw.interfaces.ControllerVisitor;
import es.upm.miw.models.Game;
import es.upm.miw.models.State;
import es.upm.miw.utils.Option;

public class MenuController extends Controller implements es.upm.miw.interfaces.MenuController {

	private int option;

	protected MenuController(Game game) {
		super(game);
		this.option = 0;
	}

	protected int getOption() {
		return this.option;
	}

	@Override
	public void setOption(int option) {
		assert ((option > 0) && (option <= Option.values().length));
		this.option = option;
		this.setState(State.IN_GAME);
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
	}

}
