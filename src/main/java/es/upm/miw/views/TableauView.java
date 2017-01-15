package es.upm.miw.views;

import es.upm.miw.interfaces.PresenterController;
import es.upm.miw.utils.IO;

public class TableauView {

	private PresenterController presenter;

	protected TableauView() {
	}

	protected void setPresenter(PresenterController presenter) {
		assert presenter != null;
		this.presenter = presenter;
	}

	protected void write() {
		IO.getInstance().writeln(IO.DOUBLE_HORIZONTAL_LINE);

		this.writeDeck();
		this.writeWaste();
		this.writeFoundations();
		this.writePiles();
	}

	private void writeDeck() {
		IO.getInstance().write("Baraja: ");

		if (this.presenter.deckIsEmpty())
			IO.getInstance().writeln("<vacío>");
		else
			IO.getInstance().writeln("[X,X]");
	}

	private void writeWaste() {
		IO.getInstance().write("Descarte: ");

		if (this.presenter.wasteIsEmpty())
			IO.getInstance().writeln("<vacío>");
		else {
			for (int card = 0; card < this.presenter.getWasteCards().size(); card++)
				IO.getInstance().write(this.presenter.getWasteCards().get(card).toString());

			IO.getInstance().writeln();
		}
	}

	private void writeFoundations() {
		for (int foundation = 1; foundation <= this.presenter.numberOfFoundations(); foundation++) {
			IO.getInstance().write("Palo " + this.presenter.getFoundationSuit(foundation).toString() + ": ");

			if (this.presenter.foundationIsEmpty(foundation))
				IO.getInstance().writeln("<vacío>");
			else
				IO.getInstance().writeln(this.presenter.getFirstFoundationCard(foundation).toString());
		}
	}

	private void writePiles() {
		for (int pile = 0; pile < this.presenter.numberOfPiles(); pile++) {
			IO.getInstance().write("Escalera " + (pile + 1) + ": ");

			for (int card = 0; card < this.presenter.getPileCards(pile).size(); card++) {
				if (this.presenter.cardIsUpturned(pile, card))
					IO.getInstance().write(this.presenter.getPileCards(pile).get(card).toString());
				else if ((this.presenter.numberOfUpturnedCards(pile) == 0)
						&& this.presenter.equalsToFirstCard(pile, card))
					IO.getInstance().write("[X,X]");
				else
					IO.getInstance().write("[");
			}
			
			IO.getInstance().writeln();
		}
	}

}
