/**
 * http://www.tutorialspoint.com/java8/java8_optional_class.htm
 */
package nl.bos.java8.optional_class;

import static nl.bos.java8.common.IConstants.INT_TEN;
import static nl.bos.java8.common.IConstants.STR_END;
import static nl.bos.java8.common.IConstants.STR_START;

import java.util.Optional;

/**
 * @author bosa
 *
 */
public class PlayWithOC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(STR_START);
		
		Integer value1 = null;
		Integer value2 = new Integer(INT_TEN);

		Optional<Integer> a = Optional.ofNullable(value1);
		Optional<Integer> b = Optional.of(value2);

		System.out.println(PlayWithOC.sum(a, b));
		
		System.out.println(STR_END);
	}

	private static Integer sum(Optional<Integer> a, Optional<Integer> b) {
		System.out.println(a.isPresent());
		System.out.println(b.isPresent());

		Integer value1 = a.orElse(new Integer(1));
		Integer value2 = b.get();

		return value1 + value2;
	}
}