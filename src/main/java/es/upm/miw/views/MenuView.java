package es.upm.miw.views;

import es.upm.miw.interfaces.MenuController;
import es.upm.miw.utils.IO;
import es.upm.miw.utils.Option;

public class MenuView {

	protected void interact(MenuController menuController) {
		this.write();
		menuController.setOption(this.getOption());
	}

	private int getOption() {
		int option = 0;

		while (option == 0) {
			option = IO.getInstance().readInt(InputMessage.GET_OPTION.toString());

			if ((option > 0) && (option <= Option.values().length))
				return option;
			else {
				IO.getInstance().writeln(Error.WRONG_MENU_OPTION.toString());
				option = 0;
			}
		}

		return option;
	}

	protected void write() {
		IO.getInstance().writeln(InputMessage.SINGLE_HORIZONTAL_LINE.toString());

		for (int option = 1; option <= Option.values().length; option++)
			IO.getInstance().writeln(option + ". " + Option.values()[option - 1].toString());
	}

}
