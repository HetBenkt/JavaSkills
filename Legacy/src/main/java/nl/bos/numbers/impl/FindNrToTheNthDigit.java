/**
 * Find Nr's
 * Enter a number and have the program generate PI up to that many decimal places. Keep a limit to how far the program will go.
 */
package nl.bos.numbers.impl;

import java.math.BigDecimal;

/**
 * @author bosa
 * 
 */
public class FindNrToTheNthDigit {

	protected long loopIndex = 0;
	protected BigDecimal NrValue = null;
	protected BigDecimal NrPreviousValue = null;
	protected BigDecimal divisor = null;
	protected BigDecimal augend = null;
	protected boolean NrReachedNumberOfDigets = true;
	protected int numberOfDigits = 0;

	public FindNrToTheNthDigit(int numberOfDigits) {
		this.numberOfDigits = numberOfDigits;
	}

	/**
	 * Check if next loop need to be done
	 */
	public void finalLoopCheck() {
		if (NrPreviousValue != null) {
			if (NrPreviousValue.compareTo(NrValue) == 0)
				NrReachedNumberOfDigets = false;
		}

		loopIndex++;
		NrPreviousValue = NrValue;
	}
}
