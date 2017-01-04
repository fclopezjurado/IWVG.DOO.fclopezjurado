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
public class TurnController extends Controller {
	/**
	 * @param game
	 */
	public TurnController(Game game) {
		super(game);
	}

	/**
	 * 
	 */
	@Override
	public void execute() {
		int pileNumber = IO.getInstance().readPileNumber(Tableau.PILES);
		
		if (!this.getTableau().turnCardInPile(pileNumber))
			IO.getInstance().writeln(Error.INVALID_CARD_TURN.toString());

		this.getTableau().write();
	}
}
