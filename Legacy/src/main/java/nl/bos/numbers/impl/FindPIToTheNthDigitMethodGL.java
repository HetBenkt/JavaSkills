/**
 * Implementation for calculating PI based on Gregory and Leibniz method
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
public class FindPIToTheNthDigitMethodGL extends FindNrToTheNthDigit implements IFindNrToTheNthDigit {
	
	public FindPIToTheNthDigitMethodGL(int numberOfDigits) {
		super(numberOfDigits);
		divisor = new BigDecimal(1.0);
		augend = new BigDecimal(2.0);
		NrValue = START_VALUE.divide(divisor);
	}

	@Override
	public boolean searchForNr() {
		System.out.println(METHOD_PI_GREGORY_LEIBNIZ);
		// PI = (4/1) - (4/3) + (4/5) - (4/7) + (4/9) - (4/11) + (4/13) -
		// (4/15) ...
		while (NrReachedNumberOfDigets) {
			divisor = divisor.add(augend);

			if (loopIndex % 2 == 0) {
				NrValue = NrValue.subtract(START_VALUE.divide(divisor,
						numberOfDigits, BigDecimal.ROUND_FLOOR));
				System.out.println(String.format(OUTPUT_LOOP_INDEX, loopIndex,
						STR_PI + " -", NrValue, divisor));
			} else {
				NrValue = NrValue.add(START_VALUE.divide(divisor,
						numberOfDigits, BigDecimal.ROUND_FLOOR));
				System.out.println(String.format(OUTPUT_LOOP_INDEX, loopIndex,
						STR_PI + " +", NrValue, divisor));
			}
			
			finalLoopCheck();
		}
		
		return NrReachedNumberOfDigets;
	}
}
