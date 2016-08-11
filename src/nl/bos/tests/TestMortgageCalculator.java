/**
 * 
 */
package nl.bos.tests;

import static org.junit.Assert.assertEquals;
import nl.bos.numbers.IMortgageCalculator;

import org.junit.Before;
import org.junit.Test;

/**
 * @author bosa
 *
 */
public class TestMortgageCalculator {
	private String expected;
	private int loanAmount;
	private int nrOfPayments;
	private double interestRate;
	private int compounding;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		expected = "1237,53";
		loanAmount = 240000;
		nrOfPayments = 360; // 30 years
		interestRate = 4.65; // Percentage
		compounding = 3;
	}

	/**
	 * Test method for
	 * {@link nl.bos.numbers.IMortgageCalculator#calcMonthlyPayment(int, int, double, int)}
	 * .
	 */
	@Test
	public void testCalcMonthlyPayment() {
		double equivalentInterestRate = IMortgageCalculator
				.calcEquivalentInterestRate(interestRate,
						IMortgageCalculator.getCompoundingValue(compounding));
		String actual = String.format("%.2f", IMortgageCalculator
				.calcMonthlyPayment(loanAmount, nrOfPayments,
						equivalentInterestRate,
						IMortgageCalculator.PAYMENT_FREQUENCY));
		assertEquals(expected, actual);
	}

}
