/**
 * 
 */
package es.upm.miw.models;

import java.util.Random;

/**
 * @author FCL
 *
 */
public class Card {
	private CardNumber number;
	private Suit pip;
	private boolean upturned;

	/**
	 * @param upturned
	 */
	protected Card() {
		this.number = CardNumber.values()[new Random().nextInt(CardNumber.values().length)];
		this.pip = Suit.values()[new Random().nextInt(Suit.values().length)];
		this.upturned = false;
	}

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
	 * @return the pip
	 */
	protected Suit getPip() {
		return pip;
	}

	/**
	 * @return the upturned
	 */
	protected boolean isUpturned() {
		return upturned;
	}

	/**
	 * @return
	 */
	protected Card turn() {
		this.upturned = this.isUpturned() ? false : true;
		return this;
	}

	/*
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object object) {
		assert object != null;
		Card card = (Card) object;
		return ((this.number == card.number) && (this.pip == card.pip) && (this.upturned == card.upturned));
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[" + this.number.toString() + "," + this.pip.toString() + "]";
	}
}
