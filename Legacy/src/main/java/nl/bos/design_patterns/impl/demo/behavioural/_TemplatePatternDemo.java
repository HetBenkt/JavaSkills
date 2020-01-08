/**
 * In Template pattern, an abstract class exposes defined way(s)/template(s) to execute its methods. Its subclasses can override the method implementation as per need but the invocation is to be in the same way as defined by an abstract class.
 * BEHAVIORAL
 * http://www.tutorialspoint.com/design_pattern/
 */
package nl.bos.design_patterns.impl.demo.behavioural;

import nl.bos.design_patterns.impl.Cricket;
import nl.bos.design_patterns.impl.Football;
import nl.bos.design_patterns.impl.Game;

import static nl.bos.design_patterns.IConstants.STR_EMPTY;
import static nl.bos.design_patterns.IConstants.STR_SEPERATOR;

/**
 * @author bosa
 *
 */
public class _TemplatePatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Game game = new Cricket();
		game.play();
		
		System.out.println(String.format(STR_SEPERATOR, STR_EMPTY));
		
		game = new Football();
		game.play();
	}
}
