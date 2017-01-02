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
	INVALID_CARD_TURN("ERROR!!! No se puede voltear una carta descubierta"),
	INVALID_PILE_NUMBER("ERROR!!! La escalera no existe"),
	INVALID_SUIT("ERROR!!! El palo no existe");
	
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
