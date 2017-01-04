/**
 * 
 */
package es.upm.miw.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author FCL
 *
 */
public class IO {
	private static final String INT_FORMAT = "entero";
	private static final String CHAR_FORMAT = "caracter";
	public static final String DOUBLE_HORIZONTAL_LINE = "===========================";
	private static final String SINGLE_HORIZONTAL_LINE = "---------------------------";
	private static IO io;
	private BufferedReader bufferedReader;

	/**
	 * 
	 */
	private IO() {
		this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	}

	/**
	 * @return
	 */
	public static IO getInstance() {
		if (io == null)
			io = new IO();

		return io;
	}

	/**
	 * @param inputMessage
	 * @return
	 */
	private int readInt(String inputMessage) {
		int input = 0;
		boolean ok = false;

		while (!ok) {
			this.write(inputMessage);

			try {
				input = Integer.parseInt(bufferedReader.readLine());
				ok = true;
			} catch (Exception ex) {
				this.writeFormatError(INT_FORMAT);
			}
		}

		return input;
	}
	
	/**
	 * @param inputMessage
	 * @return
	 */
	public int readNumberOfCards() {
		int numberOfCards = 0;

		while (numberOfCards == 0) {
			numberOfCards = this.readInt(InputMessage.NUMBER_OF_CARDS_TO_MOVE.toString());

			if (numberOfCards > 0)
				return numberOfCards;
			else {
				this.writeln(Error.INVALID_NUMBER_OF_CARD_TO_MOVE.toString());
				numberOfCards = 0;
			}
		}

		return numberOfCards;
	}

	/**
	 * @param inputMessage
	 * @return
	 */
	public int readMenuOption() {
		int option = 0;

		while (option == 0) {
			option = this.readInt(InputMessage.GET_OPTION.toString());

			if ((option > 0) && (option <= Option.values().length))
				return option;
			else {
				this.writeln(Error.WRONG_MENU_OPTION.toString());
				option = 0;
			}
		}

		return option;
	}

	/**
	 * @param inputMessage
	 * @param numberOfPiles
	 * @return
	 */
	public int readPileNumber(int numberOfPiles) {
		int pileNumber = 0;

		while (pileNumber == 0) {
			pileNumber = this.readInt(InputMessage.PILE_NUMBER + "[1," + numberOfPiles + "]: ");

			if ((pileNumber > 0) && (pileNumber <= numberOfPiles))
				return pileNumber;
			else {
				this.writeln(Error.INVALID_PILE_NUMBER.toString());
				pileNumber = 0;
			}
		}

		return pileNumber;
	}

	/**
	 * @param inputMessage
	 * @param suits
	 * @return
	 */
	public String readSuit(String inputMessage, ArrayList<String> suits) {
		String inputSuit = "";
		boolean OK = false;

		while (!OK) {
			this.write(inputMessage);

			try {
				inputSuit = bufferedReader.readLine();

				for (String suit : suits)
					if (inputSuit.equals(suit))
						OK = true;

				if (!OK)
					this.writeln(Error.INVALID_SUIT.toString());
			} catch (Exception ex) {
				this.writeFormatError(CHAR_FORMAT);
			}
		}

		return inputSuit;
	}

	/**
	 * 
	 */
	public void writeln() {
		System.out.println();
	}

	/**
	 * @param string
	 */
	public void write(String string) {
		System.out.print(string);
	}

	/**
	 * @param string
	 */
	public void writeln(String string) {
		System.out.println(string);
	}
	
	/**
	 * 
	 */
	public void writeGameMenu() {
		this.writeln(SINGLE_HORIZONTAL_LINE);
		
		for (int option = 1; option <= Option.values().length; option++)
			this.writeln(option + ". " + Option.values()[option - 1].toString());
	}

	/**
	 * @param formatError
	 */
	private void writeFormatError(String formatError) {
		this.writeln("ERROR DE FORMATO! Introduzca un valor con formato " + formatError + ".");
	}
}
