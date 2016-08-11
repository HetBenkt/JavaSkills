/**
 * In Strategy pattern, a class behavior or its algorithm can be changed at run time. we create objects which represent various strategies and a context object whose behavior varies as per its strategy object. The strategy object changes the executing algorithm of the context object.
 * BEHAVIORAL
 * http://www.tutorialspoint.com/design_pattern/ 
 */
package nl.bos.design_patterns.impl.demo.behavioural;

import nl.bos.design_patterns.impl.Context;
import nl.bos.design_patterns.impl.OperationAdd;
import nl.bos.design_patterns.impl.OperationMultiply;
import nl.bos.design_patterns.impl.OperationSubstract;

/**
 * @author bosa
 *
 */
public class _StrategyPatternDemo {
	private final static int INT_FIVE = 5;
	private final static int INT_TEN = 10;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Context context = new Context(new OperationAdd());
		System.out.println(String.format(INT_FIVE + " + " + INT_TEN + " = %s",
				context.executeStrategy(INT_FIVE, INT_TEN)));

		context = new Context(new OperationSubstract());
		System.out.println(String.format(INT_FIVE + " - " + INT_TEN + " = %s",
				context.executeStrategy(INT_FIVE, INT_TEN)));

		context = new Context(new OperationMultiply());
		System.out.println(String.format(INT_FIVE + " * " + INT_TEN + " = %s",
				context.executeStrategy(INT_FIVE, INT_TEN)));
	}
}
