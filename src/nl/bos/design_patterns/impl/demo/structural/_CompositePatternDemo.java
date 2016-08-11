/**
 * Composite pattern is used where we need to treat a group of objects in similar way as a single object. Composite pattern composes objects in term of a tree structure to represent part as well as whole hierarchy.
 * STRUCTURAL
 * http://www.tutorialspoint.com/design_pattern/adapter_pattern.htm
 */
package nl.bos.design_patterns.impl.demo.structural;

import static nl.bos.design_patterns.IConstants.STR_CEO;
import static nl.bos.design_patterns.IConstants.STR_HEAD_MARKETING;
import static nl.bos.design_patterns.IConstants.STR_HEAD_SALES;
import static nl.bos.design_patterns.IConstants.STR_MARKETING;
import static nl.bos.design_patterns.IConstants.STR_SALES;
import nl.bos.design_patterns.impl.Employee;

/**
 * @author bosa
 *
 */
public class _CompositePatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Employee CEO = new Employee("John", STR_CEO, 30000);
		Employee headSales = new Employee("Robert", STR_HEAD_SALES, 20000);
		Employee headMarketing = new Employee("Michel", STR_HEAD_MARKETING,
				2000);
		Employee clerk1 = new Employee("Laura", STR_MARKETING, 10000);
		Employee clerk2 = new Employee("Bob", STR_MARKETING, 10000);
		Employee sales1 = new Employee("Richard", STR_SALES, 10000);
		Employee sales2 = new Employee("Rob", STR_SALES, 10000);

		CEO.add(headSales);
		CEO.add(headMarketing);
		headSales.add(sales1);
		headSales.add(sales2);
		headMarketing.add(clerk1);
		headMarketing.add(clerk2);

		System.out.println(CEO.toConsole());

		for (Employee headEmployee : CEO.getSubordinates()) {
			System.out.println(headEmployee.toConsole());

			for (Employee employee : headEmployee.getSubordinates()) {
				System.out.println(employee.toConsole());
			}
		}
	}
}
