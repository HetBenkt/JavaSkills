/**
 * 
 */
package nl.bos.tests;

import nl.bos.numbers.IFindNrToTheNthDigit;
import nl.bos.numbers.impl.*;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * @author bosa
 *
 */
public class TestFindNrToTheNthDigit {

	@Test
	public void testPIMethodGL() {
		IFindNrToTheNthDigit iFindPIToTheNthDigit = new FindPIToTheNthDigitMethodGL(4);
		boolean result = iFindPIToTheNthDigit.searchForNr();
		assertFalse(result);
	}

	@Test
	public void testPIMethodN() {
		IFindNrToTheNthDigit iFindPIToTheNthDigit = new FindPIToTheNthDigitMethodN(4);
		boolean result = iFindPIToTheNthDigit.searchForNr();
		assertFalse(result);
	}

	@Test
	public void testPIMethodBBP() {
		IFindNrToTheNthDigit iFindPIToTheNthDigit = new FindPIToTheNthDigitMethodBBP(4);
		boolean result = iFindPIToTheNthDigit.searchForNr();
		assertFalse(result);
	}
	
	@Test
	public void testNMethodB() {
		IFindNrToTheNthDigit iFindEToTheNthDigit = new FindEToTheNthDigitMethodB(8);
		boolean result = iFindEToTheNthDigit.searchForNr();
		assertFalse(result);
	}
	
	@Test
	public void testFSMethodM() {
		IFindNrToTheNthDigit iFindEToTheNthDigit = new FindFSToTheNthDigitMethodM(4);
		boolean result = iFindEToTheNthDigit.searchForNr();
		assertFalse(result);
	}
	
	@Test
	public void testPFMethod() {
		IFindNrToTheNthDigit iFindEToTheNthDigit = new FindPFToTheNthDigitMethod(12344);
		boolean result = iFindEToTheNthDigit.searchForNr();
		assertFalse(result);
	}

}
