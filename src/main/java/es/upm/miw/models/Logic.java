/**
 * 
 */
package es.upm.miw.models;

import java.util.ArrayList;

import es.upm.miw.controllers.Controller;
import es.upm.miw.controllers.MovementFromDeckToWasteController;
import es.upm.miw.controllers.MovementFromFoundationToPileController;
import es.upm.miw.controllers.MovementFromPileToFoundationController;
import es.upm.miw.controllers.MovementFromPileToPileController;
import es.upm.miw.controllers.MovementFromWasteToDeckController;
import es.upm.miw.controllers.MovementFromWasteToFoundationController;
import es.upm.miw.controllers.MovementFromWasteToPileController;
import es.upm.miw.controllers.StartController;
import es.upm.miw.controllers.TurnController;
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
	
	/**
	 * 
	 */
	protected Logic() {
		this.game = new Game();
		this.startController = new StartController(this.game);
		this.initMovementControllers();
	}
	
	/**
	 * 
	 */
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
	
	/**
	 * @return
	 */
	private Controller getMovementController() {
		int movementControllerIndex = IO.getInstance().readMenuOption();
		
		if (movementControllerIndex > this.movementControllers.size()) {
			IO.getInstance().writeln(InputMessage.EXIT.toString());
			return null;
		}
		
		return this.movementControllers.get(movementControllerIndex - 1);
	}
	
	/**
	 * @return
	 */
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
