/**
 * Implementation for calculating E based on Bernoulli method 
 */
package nl.bos.numbers.impl;

import nl.bos.numbers.IFindNrToTheNthDigit;

import java.math.BigDecimal;

import static nl.bos.common.IContants.*;

/**
 * 
 * @author bosa
 *
 */
public class FindEToTheNthDigitMethodB extends FindNrToTheNthDigit implements
		IFindNrToTheNthDigit {

	public FindEToTheNthDigitMethodB(int numberOfDigits) {
		super(numberOfDigits);
		loopIndex = 1;
	}

	@Override
	public boolean searchForNr() {
		System.out.println(METHOD_E_BERNOULLI);
		// E = (1 + 1/n)n
		while (NrReachedNumberOfDigets) {
			divisor = new BigDecimal(loopIndex);
			augend = CONST_VALUE.divide(divisor, numberOfDigits,
					BigDecimal.ROUND_FLOOR);
			NrValue = CONST_VALUE.add(augend);
			NrValue = NrValue.pow((int) loopIndex);
			NrValue = NrValue.setScale(numberOfDigits, BigDecimal.ROUND_FLOOR);
			System.out.println(String.format(OUTPUT_LOOP_INDEX, loopIndex,
					STR_E, NrValue, augend));

			finalLoopCheck();
		}

		return NrReachedNumberOfDigets;
	}
}
