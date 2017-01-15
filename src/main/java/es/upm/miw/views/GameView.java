package es.upm.miw.views;

import es.upm.miw.interfaces.MovementController;
import es.upm.miw.interfaces.MovementControllerVisitor;
import es.upm.miw.interfaces.MovementFromOriginToDestinyController;
import es.upm.miw.interfaces.MovementToKnownDestinyController;
import es.upm.miw.interfaces.MovementToUnknownDestinyController;
import es.upm.miw.interfaces.SmartMovementFromOriginToDestinyController;
import es.upm.miw.interfaces.SmartMovementToKnownDestinyController;
import es.upm.miw.interfaces.SmartMovementToUnknownDestinyController;
import es.upm.miw.utils.IO;

public class GameView implements MovementControllerVisitor {

	private GetNumberOfCardsView getNumberOfCardsView;
	private GetPileNumberView getPileNumberView;
	private GetFoundationView getFoundationView;
	private TableauView tableauView;

	protected void interact(MovementController movementController) {
		this.getNumberOfCardsView = new GetNumberOfCardsView();
		this.getPileNumberView = new GetPileNumberView();
		this.getFoundationView = new GetFoundationView();
		this.tableauView = new TableauView();
		movementController.accept(this);
	}

	@Override
	public void visit(MovementFromOriginToDestinyController movementFromOriginToDestinyController) {
		int foundationNumber = getFoundationView
				.getFoundation(movementFromOriginToDestinyController.numberOfFoundations());
		int destinyPileNumber = getPileNumberView.getPileNumber(movementFromOriginToDestinyController.numberOfPiles());

		if (!movementFromOriginToDestinyController.move(foundationNumber, destinyPileNumber))
			IO.getInstance().writeln(Error.INVALID_MOVEMENT.toString());

		this.tableauView.setPresenter(movementFromOriginToDestinyController);
		this.tableauView.write();
	}

	@Override
	public void visit(SmartMovementFromOriginToDestinyController smartMovementFromOriginToDestinyController) {
		int originPileNumber = getPileNumberView
				.getPileNumber(smartMovementFromOriginToDestinyController.numberOfPiles());
		int numberOfCardsToMove = getNumberOfCardsView.getNumberOfCards();
		int destinyPileNumber = getPileNumberView
				.getPileNumber(smartMovementFromOriginToDestinyController.numberOfPiles());

		if (!smartMovementFromOriginToDestinyController.move(originPileNumber, destinyPileNumber, numberOfCardsToMove))
			IO.getInstance().writeln(Error.INVALID_MOVEMENT.toString());

		this.tableauView.setPresenter(smartMovementFromOriginToDestinyController);
		this.tableauView.write();
	}

	@Override
	public void visit(MovementToUnknownDestinyController movementToUnknownDestinyController) {
		int pileNumber = getPileNumberView.getPileNumber(movementToUnknownDestinyController.numberOfPiles());

		if (!movementToUnknownDestinyController.move(pileNumber))
			IO.getInstance().writeln(Error.INVALID_MOVEMENT.toString());

		this.tableauView.setPresenter(movementToUnknownDestinyController);
		this.tableauView.write();
	}

	@Override
	public void visit(MovementToKnownDestinyController movementToKnownDestinyController) {
		movementToKnownDestinyController.move();
		this.tableauView.setPresenter(movementToKnownDestinyController);
		this.tableauView.write();
	}

	@Override
	public void visit(SmartMovementToUnknownDestinyController smartMovementToUnknownDestinyController) {
		int pileNumber = getPileNumberView.getPileNumber(smartMovementToUnknownDestinyController.numberOfPiles());

		if (!smartMovementToUnknownDestinyController.move(pileNumber))
			IO.getInstance().writeln(Error.INVALID_MOVEMENT.toString());

		if (smartMovementToUnknownDestinyController.playerHasWon())
			IO.getInstance().writeln(InputMessage.GAME_HAS_BEEN_FINISHED.toString());
		else {
			this.tableauView.setPresenter(smartMovementToUnknownDestinyController);
			this.tableauView.write();
		}
	}

	@Override
	public void visit(SmartMovementToKnownDestinyController smartMovementToKnownDestinyController) {
		if (!smartMovementToKnownDestinyController.move())
			IO.getInstance().writeln(Error.INVALID_MOVEMENT.toString());

		if (smartMovementToKnownDestinyController.playerHasWon())
			IO.getInstance().writeln(InputMessage.GAME_HAS_BEEN_FINISHED.toString());
		else {
			this.tableauView.setPresenter(smartMovementToKnownDestinyController);
			this.tableauView.write();
		}
	}

}
