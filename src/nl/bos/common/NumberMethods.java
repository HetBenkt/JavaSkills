/**
 * Common helper methods for the calculating Math numbers 
 */
package nl.bos.common;

import java.math.BigDecimal;
import java.util.regex.Pattern;

/**
 * 
 * @author bosa
 *
 */
public class NumberMethods {
	private int nextPrimeValueIndex = 0;
	private int numberOfDigits = 0;
	
	public NumberMethods() {}

	public NumberMethods(int numberOfDigits) {
		this.numberOfDigits = numberOfDigits;
	}
	
	/**
	 * Check if input format is correct
	 * @param regex Regular Expression to apply
	 * @param dimentions The input String to apply the regex to
	 * @return true | false if String is correct for the regex
	 */
	public static boolean isCorrectFormat(String regex, String dimentions) {				
		return Pattern.matches(regex, dimentions);
	}
	
	/**
	 * Calculates the next PRIME number in the index
	 * @return	BigDecimal The next prime value in the index
	 */
	public BigDecimal getNextPrimeValue() {
		BigDecimal primeValue = null;
		for (int i = nextPrimeValueIndex; i < numberOfDigits; i++) {
			if(isPrimeNumber(i)) {
				primeValue = new BigDecimal(i);
				nextPrimeValueIndex = i+1;
				break;
			}
		}
		return primeValue;
	}
	
	/**
	 * Calculates if the input number is a PRIME number; Otherwise we don't need to factorize
	 * @param numberOfDigits	Input from the end user
	 * @return boolean if input is a PRIME number
	 */
	public boolean isPrimeNumber(int numberOfDigits) {
		boolean result = false;

		BigDecimal startValue = new BigDecimal(numberOfDigits);
		int divisorindex = 0;
		for (int i = 1; i <= numberOfDigits; i++) {
			if (i % 100000 == 0)
				System.out.print(".");
			BigDecimal divisor = new BigDecimal(i);
			BigDecimal divisorResult = startValue.divide(divisor, 40,
					BigDecimal.ROUND_FLOOR);
			String strResult = divisorResult.toString();
			if (strResult.substring(strResult.indexOf(".") + 1).equals(
					"0000000000000000000000000000000000000000")) { //TODO Not with all these zero's!
				divisorindex++;
			}

			if (divisorindex == 2) {
				// Maximum indexes found; We are done
				if (i == numberOfDigits) {
					// PRIME number found
					result = true;
				} else {
					// We can stop searching
					break;
				}
			}
		}
		return result;
	}
}
