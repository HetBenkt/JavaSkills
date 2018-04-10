/**
 * 
 */
package nl.bos.tests;

import static org.junit.Assert.assertArrayEquals;

import java.math.BigDecimal;

import nl.bos.common.NumberMethods;

import org.junit.Test;

/**
 * @author bosa
 *
 */
public class TestGetNextPrimeNumber {

	@Test
	public void testGetNextPrimeNumber() {
		BigDecimal[] expecteds = new BigDecimal[10];
		expecteds[0] = new BigDecimal(2.0);
		expecteds[1] = new BigDecimal(3.0);
		expecteds[2] = new BigDecimal(5.0);
		expecteds[3] = new BigDecimal(7.0);
		expecteds[4] = new BigDecimal(11.0);
		expecteds[5] = new BigDecimal(13.0);
		expecteds[6] = new BigDecimal(17.0);
		expecteds[7] = new BigDecimal(19.0);
		expecteds[8] = new BigDecimal(23.0);
		expecteds[9] = new BigDecimal(29.0);

		NumberMethods nm = new NumberMethods(Integer.MAX_VALUE); // TODO No max
																	// value!

		BigDecimal[] actuals = new BigDecimal[10];
		for (int i = 0; i < actuals.length; i++) {
			actuals[i] = nm.getNextPrimeValue();
		}
		assertArrayEquals(expecteds, actuals);
	}
}
