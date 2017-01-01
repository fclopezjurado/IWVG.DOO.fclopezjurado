/**
 * 
 */
package es.upm.miw.models;

/**
 * @author FCL
 *
 */
public class Card {
	private CardNumber number;
	private Suit pip;
	private boolean upturned;

	/**
	 * @param number
	 * @param pip
	 */
	protected Card(CardNumber number, Suit pip) {
		this.number = number;
		this.pip = pip;
		this.upturned = false;
	}

	/**
	 * @param number
	 * @param pip
	 * @param upturned
	 */
	protected Card(CardNumber number, Suit pip, boolean upturned) {
		this.number = number;
		this.pip = pip;
		this.upturned = upturned;
	}

	/**
	 * @return the number
	 */
	protected CardNumber getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	protected void setNumber(CardNumber number) {
		this.number = number;
	}

	/**
	 * @return the pip
	 */
	protected Suit getPip() {
		return pip;
	}

	/**
	 * @param pip
	 *            the pip to set
	 */
	protected void setPip(Suit pip) {
		this.pip = pip;
	}

	/**
	 * @return the upturned
	 */
	protected boolean isUpturned() {
		return upturned;
	}

	/**
	 * 
	 */
	protected void turn() {
		this.upturned = this.isUpturned() ? false : true;
	}

}
