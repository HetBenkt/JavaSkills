/**
 * Filter pattern or Criteria pattern is a design pattern that enables developers to filter a set of objects using different criteria and chaining them in a decoupled way through logical operations.
 * STRUCTURAL
 * http://www.tutorialspoint.com/design_pattern/
 */
package nl.bos.design_patterns.impl.demo.structural;

import nl.bos.design_patterns.ICriteria;
import nl.bos.design_patterns.impl.*;

import java.util.ArrayList;
import java.util.List;

import static nl.bos.design_patterns.IConstants.*;

/**
 * @author bosa
 *
 */
public class FilterPatternDemo {
	public static void main(String[] args) {
		List<Person> persons = new ArrayList<Person>();

		persons.add(new Person("Robert", STR_MALE, STR_SINGLE));
		persons.add(new Person("John", STR_MALE, STR_MARRIED));
		persons.add(new Person("Laura", STR_FEMALE, STR_MARRIED));
		persons.add(new Person("Diana", STR_FEMALE, STR_SINGLE));
		persons.add(new Person("Mike", STR_MALE, STR_SINGLE));
		persons.add(new Person("Bobby", STR_MALE, STR_SINGLE));

		ICriteria male = new Criteria();
		ICriteria female = new Criteria();
		ICriteria single = new CriteriaSingle();
		ICriteria singleMale = new AndCriteria(single, male);
		ICriteria singleOrFemale = new OrCriteria(single, female);

		System.out.println("Males: ");
		printPersons(male.meetCriteria(persons, STR_MALE));

		System.out.println(STR_EMPTY);
		System.out.println("Females: ");
		printPersons(female.meetCriteria(persons, STR_FEMALE));

		System.out.println(STR_EMPTY);
		System.out.println("Single Males: ");
		printPersons(singleMale.meetCriteria(persons, STR_MALE));

		System.out.println(STR_EMPTY);
		System.out.println("Single Females: ");
		printPersons(singleMale.meetCriteria(persons, STR_FEMALE));

		System.out.println(STR_EMPTY);
		System.out.println("Single Or Females: ");
		printPersons(singleOrFemale.meetCriteria(persons, STR_FEMALE));

		System.out.println(STR_EMPTY);
		System.out.println("Single Or Males: ");
		printPersons(singleOrFemale.meetCriteria(persons, STR_MALE));
	}

	public static void printPersons(List<Person> persons) {
		for (Person person : persons) {
			System.out.println(String.format(STR_OUTPUT_PERSONS,
					person.getName(), person.getGender(),
					person.getMaritalStatus()));
		}
	}
}
