/**
 * Get next Prime number till user stops asking
 */
package nl.bos.numbers.impl;

import nl.bos.common.NumberMethods;
import nl.bos.numbers.IGetNextPrimeNumber;

import java.util.Scanner;

import static nl.bos.common.IContants.*;

/**
 * 
 * @author bosa
 *
 */
public class GetNextPrimeNumber implements IGetNextPrimeNumber {

	private boolean doNextValue = true;

	/**
	 * @param reader	Input reader from the Main class for reading console input
	 */
	public void getUserInput(Scanner reader) {
		// Create an input reader
		NumberMethods nm = new NumberMethods(Integer.MAX_VALUE); // TODO No max
																	// value!

		do {
			// Get Prime value
			System.out.println(nm.getNextPrimeValue());

			// Input for next value?
			System.out.print(INPUT_NEXT_PRIME);
			String input = STR_YES;
			input = reader.next();
			if (input.toUpperCase().equals(STR_NO))
				doNextValue = false;
		} while (doNextValue);
	}
}
