/**
 * http://www.tutorialspoint.com/java8/java8_method_references.htm
 */
package nl.bos.java8.method_references;

import static nl.bos.java8.common.IConstants.STR_END;
import static nl.bos.java8.common.IConstants.STR_START;

import java.util.Arrays;
import java.util.List;
/**
 * @author bosa
 *
 */
public class Java8Tester {
	public static void main(String[] args) {
		System.out.println(STR_START);

		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		//External iterator old
		for (int i = 0; i < numbers.size(); i++) {
			System.out.println(numbers.get(i));
		}
		
		//External iterator new
		for (Integer number : numbers) {
			System.out.println(number);
		}

		//The lambda way; internal iterator
		numbers.forEach(number -> System.out.println(number));
		
		//The reference way; internal iterator
		numbers.forEach(System.out::println);
		
		System.out.println(STR_END);
	}
}
