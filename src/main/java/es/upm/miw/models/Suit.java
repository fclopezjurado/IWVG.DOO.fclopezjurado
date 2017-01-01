/**
 * 
 */
package es.upm.miw.models;

/**
 * @author FCL
 *
 */
public enum Suit {
	GOLDS("O"), CUPS("C"), SWORDS("E"), CLUBS("B");

	private String suit;

	/**
	 * @param suit
	 */
	private Suit(String suit) {
		this.suit = suit;
	}

	/*
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return this.suit;
	}
}
