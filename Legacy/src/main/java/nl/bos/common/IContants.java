/**
 * Overall constants used in Classes as static import.
 */
package nl.bos.common;

/**
 * @author bosa
 *
 */
public interface IContants {
	public final static String INPUT_NUMBER = "Enter total of searchable digits [x > 0]: ";
	public final static String INPUT_METHOD = "Method [1. %s; 2. %s; 3. %s]: ";
	public final static String INPUT_AGAIN = "Run  again [Y(es) | N(o)]? ";
	public final static String INPUT_CHOICE = "What number to search: ";
	public final static String INPUT_COSTS = "Give the costs for %s [000.00]: ";
	public final static String INPUT_DIMENTIONS = "Give the %s dimensions [width*length]: ";
	public final static String INPUT_LOAN = "Give the loan amount: ";
	public final static String INPUT_INTEREST_RATE = "Give the interest rate (%): ";
	public final static String INPUT_COMPOUNDING = "Give the compounding [1. ANNUALLY; 2. QUATERLY; 3. MONTHLY; 4. WEEKLY; 5. DAILY]: ";
	public final static String INPUT_NR_OF_PAYMENTS = "Give the nr. of payments (months): ";
	public final static String INPUT_MONEY_AMOUNT = "Give the money payment amount: ";
	public final static String INPUT_CONVERTER = "Give the %s value to convert: ";
	public final static String INPUT_NEXT_PRIME = "Next prime [Y(es) | N(o)]: ";
	public final static String[] INPUT_CHOICE_VALUES = { "PI", "E",
			"Fibonacci Sequence", "Prime Factorization", "Next Prime Number",
			"Total Costs of Tiled Floor", "Mortgage Calculator",
			"Change Return Program", "Binary to Decimal Converter" };

	public final static float[] MONEY_VALUES = { 500.00f, 200.00f, 100.00f,
			50.00f, 20.00f, 10.00f, 5.00f, 2.00f, 1.00f, 0.50f, 0.20f, 0.10f, 0.05f,
			0.02f, 0.01f };

	public final static String OUTPUT_START = "Welcome to the search for Math numbers...";
	public final static String OUTPUT_ELAPSED_TIME = "Elapsed time: %s seconds.";
	public final static String OUTPUT_LOOP_INDEX = "%s. %s = %s [%s]";
	public final static String OUTPUT_FINAL = "Bye, Bye...";
	public final static String OUTPUT_TOTAL_CHANGE = "Total change is %s [%s]";
	
	public final static String STR_E = "E";
	public final static String STR_FS = "FS";
	public final static String STR_PI = "PI";
	public final static String STR_YES = "Y";
	public final static String STR_NO = "N";
	public final static String STR_FLOOR = "floor";
	public final static String STR_TILE = "tile";
	public final static String STR_ONE_TILE = "one tile";
	public final static String STR_THE_STUFF = "the stuff";
	public final static String STR_DECIMAL = "decimal";
	public final static String STR_BINARY = "binary";
	public final static String STR_SEPARATOR = "===============================================";

	public final static String REGEX_DIMENTIONS = "\\d*\\*\\d*"; // digits*digits
	public final static String REGEX_TWO_DIGIT_DOUBLE = "\\d+\\.\\d?\\d?"; // digits.2_digits
	public final static String REGEX_DIGIT = "\\d+"; // digits

	public final static String METHOD_PI_NILAKANTHA = "Nilakantha";
	public final static String METHOD_PI_GREGORY_LEIBNIZ = "Gregory-Leibniz";
	public final static String METHOD_PI_BAILEY_BORWEIN_PLOUFFE = "Bailey-Borwein-Plouffe";
	public final static String METHOD_E_BERNOULLI = "Bernoulli";
	public final static String METHOD_FS_MOIVRE = "Abraham de Moivre";

	public final static String ERROR_NOT_VALID = "No valid input!";
	public final static String ERROR_NO_METHOD = "No method found!";
}
