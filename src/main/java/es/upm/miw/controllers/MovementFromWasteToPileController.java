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
public class MovementFromWasteToPileController extends Controller {
	/**
	 * 
	 * @param game
	 */
	public MovementFromWasteToPileController(Game game) {
		super(game);
	}

	/**
	 * 
	 */
	@Override
	public void execute() {
		int pileNumber = IO.getInstance().readPileNumber(Tableau.PILES);
		
		if (!this.getTableau().moveFromWasteToPile(pileNumber))
			IO.getInstance().writeln(Error.INVALID_MOVEMENT_FROM_WASTE_TO_PILE.toString());

		this.getTableau().write();
	}

}
