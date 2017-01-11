/**
 * 
 */
package es.upm.miw.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author FCL
 *
 */
public class IO {
	private static final String INT_FORMAT = "entero";
	public static final String DOUBLE_HORIZONTAL_LINE = "===========================";
	private static IO io;
	private BufferedReader bufferedReader;

	private IO() {
		this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	}

	public static IO getInstance() {
		if (io == null)
			io = new IO();

		return io;
	}

	public int readInt(String inputMessage) {
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

	public void writeln() {
		System.out.println();
	}

	public void write(String string) {
		System.out.print(string);
	}

	public void writeln(String string) {
		System.out.println(string);
	}

	private void writeFormatError(String formatError) {
		this.writeln("ERROR DE FORMATO! Introduzca un valor con formato " + formatError + ".");
	}
}
