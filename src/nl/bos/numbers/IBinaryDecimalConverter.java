/**
 * Develop a converter to convert a decimal number to binary or a binary number to its decimal equivalent.
 */
package nl.bos.numbers;

import java.util.Scanner;

/**
 * 
 * @author bosa
 *
 */
public interface IBinaryDecimalConverter {
	public void setBinary(String binary);

	public void setDecimal(int decimal);

	public int getDecimal();

	public String getBinary();

	public void getUserInput(Scanner reader);

	public void displayOutput(int decimal, String binary);

	/**
	 * Converting decimal to binary
	 * 
	 * @param decimal
	 *            The input decimal value
	 * @return The converted decimal as binary String
	 */
	public static String getBinaryFromDecimal(int decimal) {
		StringBuilder result = new StringBuilder();

		while (decimal != 0) {
			double value = decimal / 2.0;
			if (value % 1 == 0) {
				// We have a whole decimal value
				result.insert(0, "0");
			} else {
				result.insert(0, "1");
			}
			decimal /= 2;
		}

		return result.toString();
	};

	/**
	 * Converting binary to decimal
	 * 
	 * @param binary
	 *            the input binary value
	 * @return The converted binary as decimal integer
	 */
	public static int getDecimalFromBinary(String binary) {
		int result = 0;

		String[] binaries = binary.split("");

		for (int i = 0; i < binaries.length; i++) {
			if (!(i == binaries.length - 1 && binaries[i].equals("0")))
				result += Math.pow(Integer.parseInt(binaries[i]) * 2,
						-(i - (binaries.length - 1)));
		}

		return result;
	};
}
