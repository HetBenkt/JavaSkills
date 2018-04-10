/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.STR_SINGLE;

import java.util.ArrayList;
import java.util.List;

import nl.bos.design_patterns.ICriteria;

/**
 * @author bosa
 *
 */
public class CriteriaSingle implements ICriteria {

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.bos.design_patterns.ICriteria#meetCriteria(java.util.List)
	 */
	@Override
	public List<Person> meetCriteria(List<Person> persons, String type) {
		List<Person> singlePersons = new ArrayList<Person>();

		for (Person person : persons) {
			if (person.getMaritalStatus().equals(STR_SINGLE)) {
				singlePersons.add(person);
			}
		}

		return singlePersons;
	}
}
