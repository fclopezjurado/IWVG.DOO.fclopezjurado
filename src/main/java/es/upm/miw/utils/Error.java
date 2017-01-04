/**
 * 
 */
package es.upm.miw.utils;

/**
 * @author FCL
 *
 */
public enum Error {
	WRONG_MENU_OPTION("ERROR!!! La opción debe ser entre 1 y " + Option.values().length + " inclusives"),
	INVALID_CARD_TURN("ERROR!!! No se pudo voltear la carta"),
	INVALID_PILE_NUMBER("ERROR!!! La escalera no existe"),
	INVALID_SUIT("ERROR!!! El palo no existe"),
	INVALID_MOVEMENT_FROM_WASTE_TO_FOUNDATION("ERROR!!! No se pudo mover de descarte a palo"),
	INVALID_MOVEMENT_FROM_WASTE_TO_PILE("ERROR!!! No se pudo mover de descarte a escalera"),
	INVALID_MOVEMENT_FROM_PILE_TO_FOUNDATION("ERROR!!! No se pudo mover de escalera a palo"),
	INVALID_NUMBER_OF_CARD_TO_MOVE("ERROR!!! Se debe mover al menos una carta"),
	INVALID_MOVEMENT_FROM_PILE_TO_PILE("ERROR!!! No se pudo mover de palo a palo");
	
	private String errorMessage;

	/**
	 * @param errorMessage
	 */
	private Error(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return this.errorMessage;
	}
}
