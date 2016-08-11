/**
 * Implementation for calculating Fibonacci Sequence based on Moivre method 
 */
package nl.bos.numbers.impl;

import static nl.bos.common.IContants.METHOD_FS_MOIVRE;
import static nl.bos.common.IContants.OUTPUT_LOOP_INDEX;
import static nl.bos.common.IContants.STR_FS;

import java.math.BigDecimal;

import nl.bos.numbers.IFindNrToTheNthDigit;

/**
 * 
 * @author bosa
 *
 */
public class FindFSToTheNthDigitMethodM extends FindNrToTheNthDigit implements
		IFindNrToTheNthDigit {

	public FindFSToTheNthDigitMethodM(int numberOfDigits) {
		super(numberOfDigits);
	}

	@Override
	public boolean searchForNr() {
		//Needed for replacement finalLoopCheck();
		String tmpZeros = "";
		for (int i = 0; i < numberOfDigits; i++) {
			tmpZeros = tmpZeros + "0";
		}

		System.out.println(METHOD_FS_MOIVRE);
		// FS = ( ((1 + sqrt(5)).pow(n)) - ((1 - sqrt(5)).pow(n)) ) / ( 2.pow(n) * sqrt(5) )  
		while (NrReachedNumberOfDigets) {
			augend = new BigDecimal(Math.sqrt(5.0)); 
			BigDecimal part1 = CONST_VALUE.add(augend);
			part1 = part1.pow((int)loopIndex);
			
			BigDecimal part2 = CONST_VALUE.subtract(augend);
			part2 = part2.pow((int)loopIndex);
						
			BigDecimal part3 = new BigDecimal(2.0).pow((int)loopIndex);
			BigDecimal multiplicand = new BigDecimal(Math.sqrt(5.0));
			part3 = part3.multiply(multiplicand);
			
			NrValue = part1.subtract(part2);
			NrValue = NrValue.divide(part3, 0, BigDecimal.ROUND_FLOOR);
			
			System.out.println(String.format(OUTPUT_LOOP_INDEX, loopIndex,
					STR_FS, NrValue, augend));

			//Replacement for finalLoopCheck();
			if (NrValue.toString().length() == tmpZeros.length()) {
				NrReachedNumberOfDigets = false;
			}

			loopIndex++;
		}
		
		return NrReachedNumberOfDigets;
	}
}
