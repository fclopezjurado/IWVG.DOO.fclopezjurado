package es.upm.miw.views;

import es.upm.miw.utils.Option;

public enum Error {
	WRONG_MENU_OPTION("ERROR!!! La opción debe ser entre 1 y " + Option.values().length + " inclusives"), 
	INVALID_MOVEMENT("ERROR!!! No se pudo realizar el movimiento"), 
	INVALID_PILE_NUMBER("ERROR!!! La escalera no existe"), 
	INVALID_SUIT("ERROR!!! El palo no existe"),
	INVALID_NUMBER_OF_CARD_TO_MOVE("ERROR!!! Se debe mover al menos una carta");

	private String errorMessage;

	private Error(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return this.errorMessage;
	}
}
