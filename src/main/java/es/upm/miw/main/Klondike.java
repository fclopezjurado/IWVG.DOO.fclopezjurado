package es.upm.miw.main;

import es.upm.miw.controllers.Controller;
import es.upm.miw.controllers.Logic;
import es.upm.miw.views.KlondikeView;

public class Klondike {
	private Logic logic;
	private KlondikeView klondikeView;

	protected Klondike() {
		this.logic = new Logic();
		this.klondikeView = new KlondikeView();
	}

	private void play() {
		Controller controller;

		do {
			controller = logic.getController();

			if (controller != null)
				klondikeView.interact(controller);
		} while (controller != null);
	}

	public static void main(String[] args) {
		new Klondike().play();
	}

}
