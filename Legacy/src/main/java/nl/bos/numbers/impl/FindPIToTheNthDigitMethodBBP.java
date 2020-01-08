/**
 * Implementation for calculating PI based on Bailey, Borwein and Plouffe method
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
public class FindPIToTheNthDigitMethodBBP extends FindNrToTheNthDigit implements
		IFindNrToTheNthDigit {

	public FindPIToTheNthDigitMethodBBP(int numberOfDigits) {
		super(numberOfDigits);
		NrValue = new BigDecimal(0.0);
	}

	@Override
	public boolean searchForNr() {
		System.out.println(METHOD_PI_BAILEY_BORWEIN_PLOUFFE);
		// Pi = SUM k=0 to infinity 16-k [ 4/(8k+1) - 2/(8k+4) - 1/(8k+5) -
		// 1/(8k+6) ]
		while (NrReachedNumberOfDigets) {
			double part1 = (double) 1 / (Math.pow(16, loopIndex));
			double part2 = (double) 4 / ((8 * loopIndex) + 1);
			double part3 = (double) 2 / ((8 * loopIndex) + 4);
			double part4 = (double) 1 / ((8 * loopIndex) + 5);
			double part5 = (double) 1 / ((8 * loopIndex) + 6);
			augend = new BigDecimal(part1 * (part2 - part3 - part4 - part5))
					.setScale(numberOfDigits, BigDecimal.ROUND_FLOOR);
			NrValue = NrValue.add(augend);

			System.out.println(String.format(OUTPUT_LOOP_INDEX, loopIndex,
					STR_PI, NrValue, augend));

			finalLoopCheck();
		}
		
		return NrReachedNumberOfDigets;
	}
}
