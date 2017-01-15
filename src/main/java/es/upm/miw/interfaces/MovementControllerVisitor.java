package es.upm.miw.interfaces;

public interface MovementControllerVisitor {

	public void visit(MovementFromOriginToDestinyController movementFromOriginToDestinyController);

	public void visit(SmartMovementFromOriginToDestinyController smartMovementFromOriginToDestinyController);

	public void visit(MovementToUnknownDestinyController movementToUnknownDestinyController);

	public void visit(MovementToKnownDestinyController movementToKnownDestinyController);

	public void visit(SmartMovementToUnknownDestinyController smartMovementToUnknownDestinyController);

	public void visit(SmartMovementToKnownDestinyController smartMovementToKnownDestinyController);

}
