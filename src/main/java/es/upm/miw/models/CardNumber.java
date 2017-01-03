/**
 * 
 */
package es.upm.miw.models;

/**
 * @author FCL
 *
 */
public enum CardNumber {
	ONE("A"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), JACK("J"), HORSE("Q"), KING("K");

	private String cardNumber;

	/**
	 * @param cardNumber
	 */
	private CardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return this.cardNumber;
	}
}
