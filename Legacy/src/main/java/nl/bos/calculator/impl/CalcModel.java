/**
 * The Model implementation of the MVC Calculator
 * Does the calculation itself and returns the calculated value
 */
package nl.bos.calculator.impl;

/**
 * @author bosa
 *
 */
public class CalcModel {
	private String calculationValue;

	/**
	 * Calculates the value based on user input values
	 * @param numberInput The last given input from the user
	 * @param calcInput The last remembered given input from the user
	 * @param lastMathSelected The last chosen Math operator
	 */
	public void calculateValue(String numberInput, String calcInput,
			String lastMathSelected) {
		double calc = Double.parseDouble(calcInput);
		double number = Double.parseDouble(numberInput);
		switch (lastMathSelected) {
		case "+":
			calculationValue = Double.toString(addTwoValues(calc, number));
			break;
		case "-":
			calculationValue = Double
					.toString(substractTwoValues(calc, number));
			break;
		case "x":
			calculationValue = Double.toString(multiplyTwoValues(calc, number));
			break;
            case "÷":
			calculationValue = Double.toString(devideTwoValues(calc, number));
			break;
		default:
			break;
		}
	}

	private double addTwoValues(double value, double augend) {
		return value + augend;
	}

	private double substractTwoValues(double value, double subtrahend) {
		return value - subtrahend;
	}

	private double multiplyTwoValues(double value, double multiplicand) {
		return value * multiplicand;
	}

	private double devideTwoValues(double value, double divisor) {
		return value / divisor;
	}

	/**
	 * Returns the calculated value from the user input
	 * Removes the trailing zeros if its only a integer value.
	 * @return result of the calculated value
	 */
	public String getCalculationValue() {
		String result = calculationValue;
		if (calculationValue.endsWith(".0"))
			result = calculationValue.substring(0,
					calculationValue.length() - 2);

		return result;
	}
}
