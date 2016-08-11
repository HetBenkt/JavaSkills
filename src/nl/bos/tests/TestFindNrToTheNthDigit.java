/**
 * 
 */
package nl.bos.tests;

import static org.junit.Assert.assertFalse;
import nl.bos.numbers.IFindNrToTheNthDigit;
import nl.bos.numbers.impl.FindEToTheNthDigitMethodB;
import nl.bos.numbers.impl.FindFSToTheNthDigitMethodM;
import nl.bos.numbers.impl.FindPFToTheNthDigitMethod;
import nl.bos.numbers.impl.FindPIToTheNthDigitMethodBBP;
import nl.bos.numbers.impl.FindPIToTheNthDigitMethodGL;
import nl.bos.numbers.impl.FindPIToTheNthDigitMethodN;

import org.junit.Test;

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
