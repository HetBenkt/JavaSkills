/**
 * 
 */
package nl.bos.tests;

import nl.bos.common.NumberMethods;
import nl.bos.numbers.ITotalCostsOfTiledFloor;
import nl.bos.numbers.impl.TotalCostsOfTiledFloor;
import org.junit.Before;
import org.junit.Test;

import static nl.bos.common.IContants.REGEX_DIMENTIONS;
import static nl.bos.common.IContants.REGEX_TWO_DIGIT_DOUBLE;
import static org.junit.Assert.*;

/**
 * @author bosa
 *
 */
public class TestTotalCostsOfTiledFloor {
	private double costsOneTile, expected, floorWidth, floorLength, tileWidth, tileLength;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		costsOneTile = 1.99;
		expected = 348200.25;
		floorWidth = 300;
		floorLength = 2333;
		tileWidth = 2;
		tileLength = 2;
	}
	
	/**
	 * Test method for {@link nl.bos.numbers.impl.TotalCostsOfTiledFloor#isCorrectFormat(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testIsCorrectFormat() {
		assertTrue(NumberMethods.isCorrectFormat(REGEX_DIMENTIONS, "400*200"));
		assertTrue(NumberMethods.isCorrectFormat(REGEX_DIMENTIONS, "40000*20000"));
		assertFalse(NumberMethods.isCorrectFormat(REGEX_DIMENTIONS, "adasd*2asasd00"));
		assertFalse(NumberMethods.isCorrectFormat(REGEX_DIMENTIONS, "adasd2asasd00"));
		assertTrue(NumberMethods.isCorrectFormat(REGEX_TWO_DIGIT_DOUBLE, "23.34"));
		assertFalse(NumberMethods.isCorrectFormat(REGEX_TWO_DIGIT_DOUBLE, "23.343"));
	}
	
	/**
	 * Test method for {@link nl.bos.numbers.impl.TotalCostsOfTiledFloor#getTotalCosts(long, double)}.
	 */
	@Test
	public void testGetTotalCosts() {
		ITotalCostsOfTiledFloor iTotalCostsOfTiledFloor = new TotalCostsOfTiledFloor();
		double surfaceFloor = iTotalCostsOfTiledFloor.getTotalSurface(floorWidth, floorLength);
		double surfaceTile = iTotalCostsOfTiledFloor.getTotalSurface(tileWidth, tileLength);
		long totalTiles =  iTotalCostsOfTiledFloor.getTotalTilesForSurface(surfaceFloor, surfaceTile);
		double delta = 0.0;
		assertEquals(expected, iTotalCostsOfTiledFloor.getTotalCosts(totalTiles, costsOneTile), delta);
	}
}
