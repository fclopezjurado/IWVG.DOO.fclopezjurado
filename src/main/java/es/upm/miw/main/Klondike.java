/**
 * 
 */
package es.upm.miw.main;

import es.upm.miw.controllers.Controller;
import es.upm.miw.controllers.Logic;

/**
 * @author FCL
 *
 */
public class Klondike {
	private Logic logic;

	protected Klondike() {
		this.logic = new Logic();
	}

	private void play() {
		Controller controller;

		do {
			controller = logic.getController();

			if (controller != null)
				controller.execute();
		} while (controller != null);
	}

	public static void main(String[] args) {
		new Klondike().play();
	}
}
