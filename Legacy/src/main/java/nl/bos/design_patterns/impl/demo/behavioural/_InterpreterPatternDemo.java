/**
 * Interpreter pattern provides a way to evaluate language grammar or expression; This pattern is used in SQL parsing, symbol processing engine etc.
 * BEHAVIORAL
 * http://www.tutorialspoint.com/design_pattern/
 */
package nl.bos.design_patterns.impl.demo.behavioural;

import nl.bos.design_patterns.IExpression;
import nl.bos.design_patterns.impl.AndExpression;
import nl.bos.design_patterns.impl.OrExpression;
import nl.bos.design_patterns.impl.TerminalExpression;

import static nl.bos.design_patterns.IConstants.*;

/**
 * @author bosa
 *
 */
public class _InterpreterPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IExpression isMale = getMaleExpression();
		IExpression isMarriesWoman = getMarriesWomanExpression();

		System.out.println(String.format("%s is male? %s", STR_JOHN,
				isMale.interpret(STR_JOHN)));
		System.out.println(String.format("%s is a %s woman? %s", STR_JULIE,
				STR_MARRIED,
				isMarriesWoman.interpret(STR_MARRIED + STR_SPACE + STR_JULIE)));
	}

	private static IExpression getMarriesWomanExpression() {
		IExpression julie = new TerminalExpression(STR_JULIE);
		IExpression married = new TerminalExpression(STR_MARRIED);
		return new AndExpression(julie, married);
	}

	private static IExpression getMaleExpression() {
		IExpression robert = new TerminalExpression(STR_ROBERT);
		IExpression john = new TerminalExpression(STR_JOHN);
		return new OrExpression(robert, john);
	}
}
