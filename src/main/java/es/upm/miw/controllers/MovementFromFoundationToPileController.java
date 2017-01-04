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
public class MovementFromFoundationToPileController extends Controller {
	/**
	 * 
	 * @param game
	 */
	public MovementFromFoundationToPileController(Game game) {
		super(game);
	}

	/**
	 * 
	 */
	@Override
	public void execute() {
		int foundationNumber = IO.getInstance().readFoundation(Tableau.FOUNDATIONS);
		int destinyPileNumber = IO.getInstance().readPileNumber(Tableau.PILES);
		
		if (!this.getTableau().moveFromFoundationToPile(foundationNumber, destinyPileNumber))
			IO.getInstance().writeln(Error.INVALID_MOVEMENT_FROM_FOUNDATION_TO_PILE.toString());

		this.getTableau().write();
	}

}
