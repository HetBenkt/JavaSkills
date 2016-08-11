/**
 * The user enters a cost and then the amount of money given. The program will figure out the change and the number of quarters, dimes, nickels, pennies needed for the change.
 */
package nl.bos.numbers;

import java.util.Scanner;

/**
 * @author bosa
 *
 */
public interface IChangeReturnProgram {
	/**
	 * Reads the input from the console
	 * 
	 * @param reader
	 *            The console reader object
	 */
	public void getUserInput(Scanner reader);

	/**
	 * Shows the output for the application
	 * 
	 * @param changeMoney
	 *            The output value we would like to show
	 */
	public void displayOutput(String changeMoney);

	/**
	 * Gets the change of money
	 * 
	 * @return String representation of the money to return
	 */
	public String getChangeMoney();
}
