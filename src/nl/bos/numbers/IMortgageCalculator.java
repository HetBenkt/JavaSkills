/**
 * Calculate the monthly payments of a fixed term mortgage over given Nth terms at a given interest rate. Also figure out how long it will take the user to pay back the loan. For added complexity, add an option for users to select the compounding interval (Monthly, Weekly, Daily, Continually).
 * http://www.calculatorsoup.com/calculators/financial/loan-calculator-advanced.php
 */
package nl.bos.numbers;

import java.util.Scanner;

/**
 * @author bosa
 *
 */
public interface IMortgageCalculator {
	public final static int PAYMENT_FREQUENCY = 12; // 12 per year (once a
													// month)

	public void getUserInput(Scanner reader);

	public void displayOutput(double equivalentInterestRate);

	/**
	 * Calculates the equivalent interest rate for the monthly payment
	 * calculation
	 * 
	 * @param interestRate
	 *            The interest rate in percentage
	 * @param compounding
	 *            The value for the compounding the interest rate
	 * @return the value for the equivalent interest rate
	 */
	public static double calcEquivalentInterestRate(double interestRate,
			double compounding) {
		double pow = Math.pow(1 + ((interestRate / 100) / compounding),
				compounding / PAYMENT_FREQUENCY);

		return PAYMENT_FREQUENCY * (pow - 1);
	}

	/**
	 * Calculates the monthly payment
	 * 
	 * @param loanAmount
	 *            The amount of the loan
	 * @param nrOfPayments
	 *            The number of total payment (360 for 30 year)
	 * @param equivalentInterestRate
	 *            Calculated value from calcEquivalentInterestRate(..)
	 * @param paymentFrequency
	 *            The frequency of the payment (default 12 for per month)
	 * @return The calculated payment for 1 month
	 */
	public static double calcMonthlyPayment(int loanAmount, int nrOfPayments,
			double equivalentInterestRate, int paymentFrequency) {
		double pow = Math.pow(1 + (equivalentInterestRate / paymentFrequency),
				-nrOfPayments);
		double pre = (equivalentInterestRate / paymentFrequency) * loanAmount;

		return pre / (1 - pow);
	}

	/**
	 * Converts the use choice to the correct compound value for calculation
	 * 
	 * @param compounding
	 *            The user input value
	 * @return The compounding value for calculation
	 */
	public static int getCompoundingValue(int compounding) {
		int result = 0;
		switch (compounding) {
		case 1:
			result = 1;
			break;
		case 2:
			result = 4;
			break;
		case 3:
			result = 12;
			break;
		case 4:
			result = 52;
			break;
		case 5:
			result = 365;
			break;
		default:
			result = 12;
			break;
		}

		return result;
	}
}
