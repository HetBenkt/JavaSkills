/**
 * http://www.tutorialspoint.com/java8/java8_streams.htm
 */
package nl.bos.java8.streams;

import static nl.bos.java8.common.IConstants.STR_END;
import static nl.bos.java8.common.IConstants.STR_START;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author bosa
 *
 */
public class PlayWithStreams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(STR_START);

		List<String> strings = Arrays.asList("abs", "", "saf", "sdws", "32ww",
				"asd");
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

		//ArrayList sample
		ArrayList<Integer> ints = new ArrayList<>();
		IntStream.rangeClosed(0, 9).forEach(ints::add);
		ints.stream().forEach(System.out::println);
		
		// 1 random int value
		Random random = new Random();
		random.ints()
			.filter(number -> (number >= 0 && number < 10))
			.limit(1)
			.forEach(System.out::println);

		System.out.println("");

		// Play with first stream....cool!!
		numbers.stream()
			.map(i -> i * i)
			.distinct()
			.filter(number -> number != 4)
			.collect(Collectors.toList())
			.forEach(System.out::println);

		System.out.println("");

		// Count empty strings
		System.out.println(strings.parallelStream()
			.filter(value -> value.isEmpty())
			.count()
		);

		// Sort an array
		strings.stream().sorted().forEach(System.out::println);

		System.out.println("");

		// 'e -> compute(e)' is the same in Lambda, but now we make a reference;
		// It could even be 'e -> e' as compute does nothing!
		System.out.println(numbers.stream()
			.mapToInt(PlayWithStreams::compute)
			.sum()
		);

		// Stream statistics
		IntSummaryStatistics stats = numbers.stream()
			.mapToInt(x -> x)
			.summaryStatistics();
		System.out.println(stats.getMax());
		System.out.println(stats.getMin());
		System.out.println(stats.getSum());
		System.out.println(stats.getAverage());

		System.out.println(STR_END);
	}

	public static int compute(int number) {
		return number;
	}
}
