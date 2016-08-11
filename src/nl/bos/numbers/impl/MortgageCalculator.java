/**
 * Implementation of the Mortgage Calculator
 */
package nl.bos.numbers.impl;

import static nl.bos.common.IContants.ERROR_NOT_VALID;
import static nl.bos.common.IContants.INPUT_COMPOUNDING;
import static nl.bos.common.IContants.INPUT_INTEREST_RATE;
import static nl.bos.common.IContants.INPUT_LOAN;
import static nl.bos.common.IContants.INPUT_NR_OF_PAYMENTS;

import java.util.Scanner;

import nl.bos.numbers.IMortgageCalculator;

/**
 * @author bosa
 *
 */
public class MortgageCalculator implements IMortgageCalculator {

	private static int loanAmount = 0;
	private static double interestRate = 0.00f;
	private static int compounding = 0; //
	private static int nrOfPayments = 0; // 360 month = 30 year

	public static double getInterestRate() {
		return interestRate;
	}

	public static void setInterestRate(double interestRate) {
		MortgageCalculator.interestRate = interestRate;
	}

	public static int getCompounding() {
		return compounding;
	}

	public static void setCompounding(int compounding) {
		MortgageCalculator.compounding = compounding;
	}

	@Override
	public void getUserInput(Scanner reader) {
		try {
			System.out.print(INPUT_LOAN);
			loanAmount = Integer.parseInt(reader.next());

			System.out.print(INPUT_INTEREST_RATE);
			interestRate = Double.parseDouble(reader.next());

			System.out.print(INPUT_COMPOUNDING);
			compounding = Integer.parseInt(reader.next());

			System.out.print(INPUT_NR_OF_PAYMENTS);
			nrOfPayments = Integer.parseInt(reader.next());

			System.out
					.println("===============================================================================");
		} catch (NumberFormatException nfe) {
			System.out.println(ERROR_NOT_VALID);
			getUserInput(reader);
		}
	}

	@Override
	public void displayOutput(double equivalentInterestRate) {
		System.out.println(String.format("%.2f", IMortgageCalculator
				.calcMonthlyPayment(loanAmount, nrOfPayments,
						equivalentInterestRate, PAYMENT_FREQUENCY)));
	}

}
