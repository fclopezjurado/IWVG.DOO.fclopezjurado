package es.upm.miw.models;

public enum Suit {
	GOLDS("O"), CUPS("C"), SWORDS("E"), CLUBS("B");

	private String suit;

	private Suit(String suit) {
		this.suit = suit;
	}

	@Override
	public String toString() {
		return this.suit;
	}

}
