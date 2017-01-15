package es.upm.miw.views;

import es.upm.miw.interfaces.Controller;
import es.upm.miw.interfaces.ControllerVisitor;
import es.upm.miw.interfaces.MenuController;
import es.upm.miw.interfaces.MovementController;
import es.upm.miw.interfaces.StartController;

public class KlondikeView implements ControllerVisitor {
	private StartView startView;
	private GameView gameView;
	private MenuView menuView;

	public KlondikeView() {
		this.startView = new StartView();
		this.gameView = new GameView();
		this.menuView = new MenuView();
	}

	public void interact(Controller controller) {
		assert controller != null;
		controller.accept(this);
	}

	@Override
	public void visit(StartController startController) {
		this.startView.interact(startController);
	}

	@Override
	public void visit(MovementController movementController) {
		this.gameView.interact(movementController);
	}

	@Override
	public void visit(MenuController menuController) {
		this.menuView.interact(menuController);
	}

}
