package es.upm.miw.views;

import es.upm.miw.interfaces.StartController;

public class StartView {

	protected void interact(StartController startController) {
		startController.start();
		TableauView tableau = new TableauView();
		tableau.setPresenter(startController);
		tableau.write();
	}

}
