/**
 * Start method for calling correct method
 */
package nl.bos;

import static nl.bos.common.IContants.ERROR_NOT_VALID;
import static nl.bos.common.IContants.INPUT_AGAIN;
import static nl.bos.common.IContants.INPUT_CHOICE;
import static nl.bos.common.IContants.INPUT_CHOICE_VALUES;
import static nl.bos.common.IContants.INPUT_METHOD;
import static nl.bos.common.IContants.INPUT_NUMBER;
import static nl.bos.common.IContants.METHOD_PI_BAILEY_BORWEIN_PLOUFFE;
import static nl.bos.common.IContants.METHOD_PI_GREGORY_LEIBNIZ;
import static nl.bos.common.IContants.METHOD_PI_NILAKANTHA;
import static nl.bos.common.IContants.OUTPUT_FINAL;
import static nl.bos.common.IContants.OUTPUT_START;
import static nl.bos.common.IContants.REGEX_DIGIT;
import static nl.bos.common.IContants.STR_NO;
import static nl.bos.common.IContants.STR_SEPARATOR;

import java.util.Scanner;

import nl.bos.common.NumberMethods;
import nl.bos.common.StopWatch;
import nl.bos.numbers.IBinaryDecimalConverter;
import nl.bos.numbers.IChangeReturnProgram;
import nl.bos.numbers.IFindNrToTheNthDigit;
import nl.bos.numbers.IGetNextPrimeNumber;
import nl.bos.numbers.IMortgageCalculator;
import nl.bos.numbers.ITotalCostsOfTiledFloor;
import nl.bos.numbers.impl.BinaryDecimalConverter;
import nl.bos.numbers.impl.ChangeReturnProgram;
import nl.bos.numbers.impl.FindEToTheNthDigitMethodB;
import nl.bos.numbers.impl.FindFSToTheNthDigitMethodM;
import nl.bos.numbers.impl.FindPFToTheNthDigitMethod;
import nl.bos.numbers.impl.FindPIToTheNthDigitMethodBBP;
import nl.bos.numbers.impl.FindPIToTheNthDigitMethodGL;
import nl.bos.numbers.impl.FindPIToTheNthDigitMethodN;
import nl.bos.numbers.impl.GetNextPrimeNumber;
import nl.bos.numbers.impl.MortgageCalculator;
import nl.bos.numbers.impl.TotalCostsOfTiledFloor;

/**
 * @author bosa
 *
 */
public class MainForNumberCases {

	/**
	 * @param args
	 *            Passing standard arguments from method call.
	 */
	public static void main(String[] args) {
		// Create an input reader
		Scanner reader = new Scanner(System.in);

		boolean again = true;
		while (again) {
			System.out.println(OUTPUT_START);

			// Read choise for number search
			for (int i = 0; i < INPUT_CHOICE_VALUES.length; i++) {
				System.out.println(i + 1 + ". " + INPUT_CHOICE_VALUES[i]);
			}
			System.out.print(INPUT_CHOICE);
			String numberOfChoice = reader.next();

			if (NumberMethods.isCorrectFormat(REGEX_DIGIT, numberOfChoice)) {
				if (Integer.parseInt(numberOfChoice) > 0) {

					// Read the number of used digits
					String numberOfDigets = "";
					int[] perm = { 1, 2, 3, 4 };
					int num = Integer.parseInt(numberOfChoice);
					if (arrayContainsNum(perm, num)) {
						System.out.print(INPUT_NUMBER);
						numberOfDigets = reader.next();
					} else
						numberOfDigets = "1";
					if (NumberMethods.isCorrectFormat(REGEX_DIGIT,
							numberOfDigets)) {
						if (Integer.parseInt(numberOfDigets) > 0) {
							// Start stopwatch and call method with parameters
							StopWatch sw = new StopWatch();
							IFindNrToTheNthDigit iFindNrToTheNthDigit = null;

							switch (Integer.parseInt(numberOfChoice)) {
							case 1:
								// Calculate PI
								// Read the method number to use
								System.out.print(String.format(INPUT_METHOD,
										METHOD_PI_GREGORY_LEIBNIZ,
										METHOD_PI_NILAKANTHA,
										METHOD_PI_BAILEY_BORWEIN_PLOUFFE));
								String methodNumber = reader.next();
								if (NumberMethods.isCorrectFormat(REGEX_DIGIT,
										methodNumber)) {
									switch (Integer.parseInt(methodNumber)) {
									case 1:
										iFindNrToTheNthDigit = new FindPIToTheNthDigitMethodGL(
												Integer.parseInt(numberOfDigets));
										break;
									case 2:
										iFindNrToTheNthDigit = new FindPIToTheNthDigitMethodN(
												Integer.parseInt(numberOfDigets));
										break;
									case 3:
										iFindNrToTheNthDigit = new FindPIToTheNthDigitMethodBBP(
												Integer.parseInt(numberOfDigets));
										break;
									default:
										break;
									}
								} else {
									System.out.println(ERROR_NOT_VALID);
								}
								break;
							case 2:
								// Calculate E
								iFindNrToTheNthDigit = new FindEToTheNthDigitMethodB(
										Integer.parseInt(numberOfDigets));
								break;
							case 3:
								// Calculate Fibonacci Sequence
								iFindNrToTheNthDigit = new FindFSToTheNthDigitMethodM(
										Integer.parseInt(numberOfDigets));
								break;
							case 4:
								// Calculate Prime Factorization
								iFindNrToTheNthDigit = new FindPFToTheNthDigitMethod(
										Integer.parseInt(numberOfDigets));
								break;
							case 5:
								// Get Next Prime Number till user stops
								IGetNextPrimeNumber iGetNextPrimeNumber = new GetNextPrimeNumber();
								iGetNextPrimeNumber.getUserInput(reader);
								break;
							case 6:
								// Calculate total costs of tiles floor
								ITotalCostsOfTiledFloor iTotalCostsOfTiledFloor = new TotalCostsOfTiledFloor();
								iTotalCostsOfTiledFloor.getUserInput(reader);
								double surfaceFloor = iTotalCostsOfTiledFloor
										.getTotalSurface(
												iTotalCostsOfTiledFloor
														.getWidthFloor(),
												iTotalCostsOfTiledFloor
														.getLenghtFloor());
								double surfaceTile = iTotalCostsOfTiledFloor
										.getTotalSurface(
												iTotalCostsOfTiledFloor
														.getWidthTile(),
												iTotalCostsOfTiledFloor
														.getLenghtTile());
								long totalTiles = iTotalCostsOfTiledFloor
										.getTotalTilesForSurface(surfaceFloor,
												surfaceTile);
								double totalCosts = iTotalCostsOfTiledFloor
										.getTotalCosts(totalTiles,
												iTotalCostsOfTiledFloor
														.getCostsOneTile());
								System.out.println("Total costs for "
										+ surfaceFloor + " m2 = " + totalCosts
										+ " [Tiles: " + totalTiles + "]");
								break;
							case 7:
								// Mortgage Calculator
								IMortgageCalculator iMortgageCalculator = new MortgageCalculator();
								iMortgageCalculator.getUserInput(reader);
								double equivalentInterestRate = IMortgageCalculator
										.calcEquivalentInterestRate(
												MortgageCalculator
														.getInterestRate(),
												IMortgageCalculator
														.getCompoundingValue(MortgageCalculator
																.getCompounding()));
								iMortgageCalculator
										.displayOutput(equivalentInterestRate);
								break;
							case 8:
								// Change Return Program
								IChangeReturnProgram iChangeReturnProgram = new ChangeReturnProgram();
								iChangeReturnProgram.getUserInput(reader);
								iChangeReturnProgram
										.displayOutput(iChangeReturnProgram.getChangeMoney());
								break;
							case 9:
								// Binary to Decimal and Back Converter
								IBinaryDecimalConverter iBinaryDecimalConverter = new BinaryDecimalConverter();
								iBinaryDecimalConverter.getUserInput(reader);
								iBinaryDecimalConverter
										.displayOutput(IBinaryDecimalConverter.getDecimalFromBinary(iBinaryDecimalConverter.getBinary()), IBinaryDecimalConverter.getBinaryFromDecimal(iBinaryDecimalConverter.getDecimal()));
								break;
							default:
								System.out.println(ERROR_NOT_VALID);
								break;
							}
							if (iFindNrToTheNthDigit != null)
								iFindNrToTheNthDigit.searchForNr();
							sw.elapsedTime();
						} else
							System.out.println(ERROR_NOT_VALID);
					} else
						System.out.println(ERROR_NOT_VALID);
				} else
					System.out.println(ERROR_NOT_VALID);
			} else
				System.out.println(ERROR_NOT_VALID);

			// Run the program again?
			System.out.print(INPUT_AGAIN);
			String againInput = reader.next();
			if (againInput.toUpperCase().equals(STR_NO)) {
				System.out.println(OUTPUT_FINAL);
				again = false;
			} else {
				System.out.println(STR_SEPARATOR);
			}
		}
		// Close the input reader
		reader.close();
	}

	private static boolean arrayContainsNum(int[] perm, int num) {
		boolean result = false;

		for (int i = 0; i < perm.length; i++) {
			if (perm[i] == num) {
				result = true;
				break;
			}
		}

		return result;
	}
}
