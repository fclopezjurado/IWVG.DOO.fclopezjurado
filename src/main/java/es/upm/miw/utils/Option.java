package es.upm.miw.utils;

public enum Option {
	MOVE_FROM_DECK_TO_WASTE("Mover de baraja a descarte"), MOVE_FROM_WASTE_TO_DECK(
			"Mover de descarte a baraja"), MOVE_FROM_WASTE_TO_FOUNDATION(
					"Mover de descarte a palo"), MOVE_FROM_WASTE_TO_PILE(
							"Mover de descarte a escalera"), MOVE_FROM_PILE_TO_FOUNDATION(
									"Mover de escalera a palo"), MOVE_FROM_PILE_TO_PILE(
											"Mover de escalera a escalera"), MOVE_FROM_FOUNDATION_TO_PILE(
													"Mover de palo a escalera"), TURN_CARD_FROM_PILE(
															"Voltear en escalera"), EXIT_GAME("Salir");

	private String option;

	private Option(String option) {
		this.option = option;
	}

	@Override
	public String toString() {
		return this.option;
	}

}
