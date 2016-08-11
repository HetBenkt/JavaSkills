/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.STR_FEMALE;
import static nl.bos.design_patterns.IConstants.STR_MALE;

import java.util.ArrayList;
import java.util.List;

import nl.bos.design_patterns.ICriteria;

/**
 * @author bosa
 *
 */
public class Criteria implements ICriteria {

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.bos.design_patterns.ICriteria#meetCriteria(java.util.List)
	 */
	@Override
	public List<Person> meetCriteria(List<Person> persons, String type) {
		List<Person> criteriaPersons = new ArrayList<Person>();
		for (Person person : persons) {
			if (person.getGender().equals(type)) {
				switch (type) {
				case STR_FEMALE:
					criteriaPersons.add(person);
					break;
				case STR_MALE:
					criteriaPersons.add(person);
					break;
				default:
					break;
				}
			}
		}

		return criteriaPersons;
	}
}
