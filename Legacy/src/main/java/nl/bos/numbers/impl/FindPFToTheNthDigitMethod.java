/**
 * Implementation for calculating Prime Factorization 
 */
package nl.bos.numbers.impl;

import nl.bos.common.NumberMethods;
import nl.bos.numbers.IFindNrToTheNthDigit;

import java.math.BigDecimal;
import java.util.Vector;

/**
 * 
 * @author bosa
 *
 */
public class FindPFToTheNthDigitMethod extends FindNrToTheNthDigit implements
		IFindNrToTheNthDigit {

	private NumberMethods nm;

	public FindPFToTheNthDigitMethod(int numberOfDigits) {
		super(numberOfDigits);
		nm = new NumberMethods(numberOfDigits);
	}

	@Override
	public boolean searchForNr() {
		if (nm.isPrimeNumber(numberOfDigits)) {
			System.out.println(numberOfDigits + " is a PRIME number");
		} else {
			System.out.println("Do Prime Factorization on Composite Number: "
					+ numberOfDigits);
			doFactorization(numberOfDigits);
		}

		return false;
	}

	/**
	 * Calculate the factorization of the input value
	 * 
	 * @param numberOfDigits
	 *            Input value from end user
	 */
	private void doFactorization(int numberOfDigits) {
		BigDecimal startValue = new BigDecimal(numberOfDigits);
		Vector<BigDecimal> primeFactors = new Vector<BigDecimal>();

		BigDecimal currentPrimeValue = nm.getNextPrimeValue();
		while (!nm.isPrimeNumber(startValue.intValueExact())) {
			BigDecimal divisorResult = startValue.divide(currentPrimeValue, 40,
					BigDecimal.ROUND_FLOOR);
			String strResult = divisorResult.toString();
			if (strResult.substring(strResult.indexOf(".") + 1).equals(
					"0000000000000000000000000000000000000000")) { // TODO Not
																	// with all
																	// these
																	// zero's!
				// Correct divide; save currentPrimeValue;
				primeFactors.add(currentPrimeValue);
				startValue = divisorResult;
			} else
				currentPrimeValue = nm.getNextPrimeValue();
		}

		for (int i = 0; i < primeFactors.size(); i++) {
			System.out.print(primeFactors.get(i) + " * ");
		}
		System.out.println(startValue.intValueExact());
	}
}
