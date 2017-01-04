/**
 * 
 */
package es.upm.miw.controllers;

import es.upm.miw.models.Game;
import es.upm.miw.models.Tableau;
import es.upm.miw.utils.Error;
import es.upm.miw.utils.IO;

/**
 * @author FCL
 *
 */
public class MovementFromPileToPileController extends Controller {
	/**
	 * 
	 * @param game
	 */
	public MovementFromPileToPileController(Game game) {
		super(game);
	}

	/**
	 * 
	 */
	@Override
	public void execute() {
		int originPileNumber = IO.getInstance().readPileNumber(Tableau.PILES);
		int numberOfCardsToMove = IO.getInstance().readNumberOfCards();
		int destinyPileNumber = IO.getInstance().readPileNumber(Tableau.PILES);
		
		if (!this.getTableau().moveFromPileToPile(originPileNumber, destinyPileNumber, numberOfCardsToMove))
			IO.getInstance().writeln(Error.INVALID_MOVEMENT_FROM_PILE_TO_PILE.toString());

		this.getTableau().write();
	}
}
