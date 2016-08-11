/**
 * 
 */
package nl.bos.java8.lambda_expressions;

import static nl.bos.java8.common.IConstants.*;

/**
 * @author bosa
 *
 */
public class Java8Tester {
	public static void main(String args[]) {
		System.out.println(STR_START);	
		
		Java8Tester tester = new Java8Tester();
		
		//ADDITION
		//The Anonymous way 
		IMathOperation additionAnonymous = new IMathOperation() {
			@Override
			public int operation(int a, int b) {
				return a + b;
			}
		};
		//The Lambda way with type declaration 
		IMathOperation additionLambda = (int a, int b) -> a + b;


		//SUBSTRACTION
		//The Anonymous way 
		IMathOperation subtractionAnonymous = new IMathOperation() {
			@Override
			public int operation(int a, int b) {
				return a - b;
			}
		};
		//The Lambda way without type declaration 
		IMathOperation subtractionLambda = (a, b) -> a - b;

		
		//MULTIPLICATION
		//The Anonymous way 
		IMathOperation multiplicationAnonymous = new IMathOperation() {
			@Override
			public int operation(int a, int b) {
				return a * b;
			}
		};
		//The Lambda way with return statement along with curly braces
		IMathOperation multiplicationLambda = (int a, int b) -> {
			return a * b;
		};

		//DIVISION
		//The Anonymous way 
		IMathOperation divisionAnonymous = new IMathOperation() {
			@Override
			public int operation(int a, int b) {
				return a / b;
			}
		};
		//The Lambda way
		IMathOperation divisionLambda = (int a, int b) -> a / b;

		System.out.println(STR_LAMBDA);
		System.out.println(INT_TEN + " + " + INT_FIVE + " = " + tester.operate(INT_TEN, INT_FIVE, additionLambda));
		System.out.println(INT_TEN + " - " + INT_FIVE + " = " + tester.operate(INT_TEN, INT_FIVE, subtractionLambda));
		System.out.println(INT_TEN + " x " + INT_FIVE + " = " + tester.operate(INT_TEN, INT_FIVE, multiplicationLambda));
		System.out.println(INT_TEN + " / " + INT_FIVE + " = " + tester.operate(INT_TEN, INT_FIVE, divisionLambda));

		System.out.println(STR_ANONYMOUS);
		System.out.println(INT_TEN + " + " + INT_FIVE + " = " + tester.operate(INT_TEN, INT_FIVE, additionAnonymous));
		System.out.println(INT_TEN + " - " + INT_FIVE + " = " + tester.operate(INT_TEN, INT_FIVE, subtractionAnonymous));
		System.out.println(INT_TEN + " x " + INT_FIVE + " = " + tester.operate(INT_TEN, INT_FIVE, multiplicationAnonymous));
		System.out.println(INT_TEN + " / " + INT_FIVE + " = " + tester.operate(INT_TEN, INT_FIVE, divisionAnonymous));

		//With parenthesis; works only with 1 parameter!
		IGreetingService greetService1 = message -> System.out.println(String.format(STR_OUTPUT_HELLO, message));

		//Without parenthesis; works only with 1 parameter!
		IGreetingService greetService2 = (message) -> System.out.println(String.format(STR_OUTPUT_HELLO, message));

		greetService1.sayMessage(STR_NAMES[0]);
		greetService2.sayMessage(STR_NAMES[1]);
		
		System.out.println(STR_END);	
	}

	@FunctionalInterface
	public interface IMathOperation {
		int operation(int a, int b);
	}

	@FunctionalInterface
	public interface IGreetingService {
		void sayMessage(String message);
	}

	private int operate(int a, int b, IMathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}
}