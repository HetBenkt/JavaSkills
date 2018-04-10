/**
 * Interface for the class
 */
package nl.bos.numbers;

import java.math.BigDecimal;

/**
 * 
 * @author bosa
 *
 */
public interface IFindNrToTheNthDigit {
	public final static BigDecimal START_VALUE = new BigDecimal(4.0);
	public final static BigDecimal CONST_VALUE = new BigDecimal(1.0);
	
	/**
	 * Method that will search for PI number
	 */
	public boolean searchForNr();
}
