/**
 * 
 */
package es.upm.miw.utils;

/**
 * @author FCL
 *
 */
public enum InputMessage {
	GET_OPTION("Opción? [1-" + Option.values().length + "]: "),
	GAME_HAS_BEEN_FINISHED("Victoria!!!!"),
	EXIT("Adios!!!"),
	PILE_NUMBER("Escalera? "),
	NUMBER_OF_CARDS_TO_MOVE("Cuántas cartas? ");
	
	private String inputMessage;

	/**
	 * @param inputMessage
	 */
	private InputMessage(String inputMessage) {
		this.inputMessage = inputMessage;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return this.inputMessage;
	}
}
