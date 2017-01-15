package es.upm.miw.models;

import java.util.Random;

public class Card {

	private CardNumber number;
	private Suit pip;
	private boolean upturned;

	protected Card() {
		this.number = CardNumber.values()[new Random().nextInt(CardNumber.values().length)];
		this.pip = Suit.values()[new Random().nextInt(Suit.values().length)];
		this.upturned = false;
	}

	protected Card(CardNumber number, Suit pip) {
		this.number = number;
		this.pip = pip;
		this.upturned = false;
	}

	protected Card(CardNumber number, Suit pip, boolean upturned) {
		this.number = number;
		this.pip = pip;
		this.upturned = upturned;
	}

	protected CardNumber getNumber() {
		return number;
	}

	protected Suit getPip() {
		return pip;
	}

	protected boolean isUpturned() {
		return upturned;
	}

	protected Card turn() {
		this.upturned = this.isUpturned() ? false : true;
		return this;
	}

	@Override
	public boolean equals(Object object) {
		assert object != null;
		Card card = (Card) object;
		return ((this.number == card.number) && (this.pip == card.pip) && (this.upturned == card.upturned));
	}

	@Override
	public String toString() {
		return "[" + this.number.toString() + "," + this.pip.toString() + "]";
	}

}
