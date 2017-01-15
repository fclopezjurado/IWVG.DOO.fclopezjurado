package es.upm.miw.interfaces;

public interface MovementController extends Controller, PresenterController {
	
	public void accept(MovementControllerVisitor movementControllerVisitor);
}
