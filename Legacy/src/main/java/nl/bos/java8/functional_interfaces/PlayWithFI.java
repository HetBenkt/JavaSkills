/**
 * http://www.tutorialspoint.com/java8/java8_functional_interfaces.htm
 * http://www.java2s.com/Tutorials/Java/java.util.function/BiConsumer/index.htm
 */
package nl.bos.java8.functional_interfaces;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static nl.bos.java8.common.IConstants.STR_END;
import static nl.bos.java8.common.IConstants.STR_START;

/**
 * @author bosa
 *
 */
public class PlayWithFI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(STR_START);
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 2);
		map.put(1, 4);
		map.put(2, 6);
		map.put(3, 8);
		map.put(4, 10);
		evalBiPredicate(map, (x, y) -> true);
		evalBiPredicate(map, (x, y) -> y >= 3);
		evalBiPredicate(map, (x, y) -> x >= 2);
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		evalPredicate(numbers, n -> true);
		evalPredicate(numbers, n -> n%2 == 0);
		evalPredicate(numbers, n -> n > 3);
		
		System.out.println("");
		
		BiPredicate<Integer, Integer> bi = (x, y) -> x > y;
		BiPredicate<Integer, Integer> eq = (x, y) -> x -2 > y;
		System.out.println(bi.test(2, 3));
		System.out.println(bi.or(eq).test(2, 3));
		System.out.println(bi.or(eq).test(8, 3));
		
		Consumer<String> consumer = c -> System.out.println(c.toUpperCase());
		consumer.accept("Hello world!");
		
		System.out.println(STR_END);
	}

	private static void evalBiPredicate(HashMap<Integer, Integer> map, BiPredicate<Integer, Integer> biPredicate) {
		System.out.println(biPredicate);
		Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
		while(it.hasNext()) {
			Entry<Integer, Integer> pair = it.next();
			if(biPredicate.test((Integer)pair.getKey(), (Integer)pair.getValue()))
				System.out.println(pair.getKey() +": "+ pair.getValue());
		}
	}
	
	private static void evalPredicate(List<Integer> numbers, Predicate<Integer> predicate) {
		System.out.println(predicate);
		for(Integer number : numbers) {
			if(predicate.test(number))
				System.out.println(number);
		}
	}
}
