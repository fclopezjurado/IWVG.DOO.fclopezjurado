package es.upm.miw.interfaces;

public interface ControllerVisitor {

	public void visit(StartController startController);

	public void visit(MovementController movementController);

	public void visit(MenuController menuController);

}
