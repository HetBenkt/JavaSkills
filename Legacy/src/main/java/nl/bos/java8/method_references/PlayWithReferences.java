/**
 * http://www.tutorialspoint.com/java8/java8_method_references.htm
 * https://blog.idrsolutions.com/2015/02/java-8-method-references-explained-5-minutes/
 */
package nl.bos.java8.method_references;

import nl.bos.java8.common.MyObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static nl.bos.java8.common.IConstants.STR_END;
import static nl.bos.java8.common.IConstants.STR_START;
/**
 * @author bosa
 *
 */
public class PlayWithReferences {
	public static void main(String[] args) {
		System.out.println(STR_START);

		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		//External iterator way
		for (Integer number : numbers) {
			PlayWithReferences.show(number);
		}

		//The reference way; internal iterator
		numbers.forEach(PlayWithReferences::show);
		
		//Reference To Constructor ClassName::new
		List<Double> squaredNumbers = PlayWithReferences.findSquareRoot(numbers, Double::new);
        System.out.println("Square root of numbers = "+squaredNumbers);
		
        List<MyObject> objects = new ArrayList<MyObject>();
        objects.add(new MyObject("NEW"));
        objects.add(new MyObject("RUN"));
        objects.add(new MyObject("END"));
        
        //Reference To an Instance Method ClassName::methodName
        List<String> allStates = PlayWithReferences.listAllObjects(objects, MyObject::getStatus);
        System.out.println(allStates);
        
		System.out.println(STR_END);
	}
	
	private static List<Double> findSquareRoot(List<Integer> list, Function<Double,Double> f) {
		List<Double> result = new ArrayList<Double>();
        list.forEach(x -> result.add(f.apply(Math.sqrt(x))));
        return result;
	}
	
	private static List<String> listAllObjects(List<MyObject> objects, Function<MyObject, String> f) {
		List<String> result = new ArrayList<String>();
		objects.forEach((MyObject x) -> result.add(f.apply(x)));
        return result;
	}

	private static void show(Integer number) {
		System.out.println(number);
	}
}
