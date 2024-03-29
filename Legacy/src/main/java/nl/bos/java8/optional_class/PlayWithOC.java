/**
 * http://www.tutorialspoint.com/java8/java8_optional_class.htm
 */
package nl.bos.java8.optional_class;

import java.util.Optional;

import static nl.bos.java8.common.IConstants.*;

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
        Integer value2 = Integer.valueOf(INT_TEN);

        Optional<Integer> a = Optional.ofNullable(value1);
        Optional<Integer> b = Optional.of(value2);

        System.out.println(PlayWithOC.sum(a, b));

        System.out.println(STR_END);
    }

	private static Integer sum(Optional<Integer> a, Optional<Integer> b) {
        System.out.println(a.isPresent());
        System.out.println(b.isPresent());

        Integer value1 = a.orElse(Integer.valueOf(1));
        Integer value2 = b.get();

        return value1 + value2;
    }
}