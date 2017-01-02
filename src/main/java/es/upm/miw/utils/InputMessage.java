/**
 * 
 */
package es.upm.miw.utils;

/**
 * @author FCL
 *
 */
public enum InputMessage {
	GET_OPTION("Opción? [1-" + Option.values().length + "]: ");
	
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
