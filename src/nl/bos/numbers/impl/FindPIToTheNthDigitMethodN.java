/**
 * Implementation for calculating PI based on Nilakantha method 
 */
package nl.bos.numbers.impl;

import static nl.bos.common.IContants.METHOD_PI_NILAKANTHA;
import static nl.bos.common.IContants.OUTPUT_LOOP_INDEX;
import static nl.bos.common.IContants.STR_PI;

import java.math.BigDecimal;

import nl.bos.numbers.IFindNrToTheNthDigit;

/**
 * 
 * @author bosa
 *
 */
public class FindPIToTheNthDigitMethodN extends FindNrToTheNthDigit implements
		IFindNrToTheNthDigit {

	private long value = 2;

	public FindPIToTheNthDigitMethodN(int numberOfDigits) {
		super(numberOfDigits);
		divisor = new BigDecimal(value * (value + 1) * (value + 2));
		augend = START_VALUE.divide(divisor, numberOfDigits,
				BigDecimal.ROUND_FLOOR);
		NrValue = new BigDecimal(3.0);
		NrValue = NrValue.add(augend);
	}

	@Override
	public boolean searchForNr() {
		System.out.println(METHOD_PI_NILAKANTHA);
		// PI = 3 + 4/(2*3*4) - 4/(4*5*6) + 4/(6*7*8) - 4/(8*9*10) +
		// 4/(10*11*12) - 4/(12*13*14) ...
		while (NrReachedNumberOfDigets) {
			value += 2;
			divisor = new BigDecimal(value * (value + 1) * (value + 2));

			if (loopIndex % 2 == 0) {
				BigDecimal subtrahend = START_VALUE.divide(divisor,
						numberOfDigits, BigDecimal.ROUND_FLOOR);
				NrValue = NrValue.subtract(subtrahend);
				System.out.println(String.format(OUTPUT_LOOP_INDEX, loopIndex,
						STR_PI + " -", NrValue, subtrahend));
			} else {
				BigDecimal subtrahend = START_VALUE.divide(divisor,
						numberOfDigits, BigDecimal.ROUND_FLOOR);
				NrValue = NrValue.add(subtrahend);
				System.out.println(String.format(OUTPUT_LOOP_INDEX, loopIndex,
						STR_PI + " +", NrValue, subtrahend));
			}

			finalLoopCheck();
		}
		
		return NrReachedNumberOfDigets;
	}
}
