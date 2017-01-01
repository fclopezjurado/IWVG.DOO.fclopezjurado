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
	public Card(CardNumber number, Suit pip) {
		super();
		this.number = number;
		this.pip = pip;
		this.upturned = false;
	}

	/**
	 * @param number
	 * @param pip
	 * @param upturned
	 */
	public Card(CardNumber number, Suit pip, boolean upturned) {
		super();
		this.number = number;
		this.pip = pip;
		this.upturned = upturned;
	}

	/**
	 * @return the number
	 */
	public CardNumber getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(CardNumber number) {
		this.number = number;
	}

	/**
	 * @return the pip
	 */
	public Suit getPip() {
		return pip;
	}

	/**
	 * @param pip
	 *            the pip to set
	 */
	public void setPip(Suit pip) {
		this.pip = pip;
	}

	/**
	 * @return the upturned
	 */
	public boolean isUpturned() {
		return upturned;
	}

	/**
	 * 
	 */
	public void turn() {
		this.upturned = this.isUpturned() ? false : true;
	}

}
