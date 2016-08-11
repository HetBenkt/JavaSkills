/**
 *  This pattern is used to get a way to access the elements of a collection object in sequential manner without any need to know its underlying representation.
 *  BEHAVIORAL
 *  http://www.tutorialspoint.com/design_pattern/
 */
package nl.bos.design_patterns.impl.demo.behavioural;

import static nl.bos.design_patterns.IConstants.STR_OUTPUT_NAME;
import nl.bos.design_patterns.IIterator;
import nl.bos.design_patterns.impl.NameRepository;

/**
 * @author bosa
 *
 */
public class _IteratorPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NameRepository namesRepository = new NameRepository();
		for (IIterator iter = namesRepository.getIterator(); iter.hasNext();) {
			System.out.println(String.format(STR_OUTPUT_NAME, iter.next()));
		}
	}
}
