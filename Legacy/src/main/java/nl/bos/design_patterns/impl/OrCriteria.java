/**
 * 
 */
package nl.bos.design_patterns.impl;

import nl.bos.design_patterns.ICriteria;

import java.util.List;

/**
 * @author bosa
 *
 */
public class OrCriteria implements ICriteria {

	private ICriteria criteria;
	private ICriteria otherCriteria;

	public OrCriteria(ICriteria criteria, ICriteria otherCriteria) {
		this.criteria = criteria;
		this.otherCriteria = otherCriteria;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.bos.design_patterns.ICriteria#meetCriteria(java.util.List)
	 */
	@Override
	public List<Person> meetCriteria(List<Person> persons, String type) {
		List<Person> firstCriteriaItems = criteria.meetCriteria(persons, type);
		List<Person> otherCriteriaItems = otherCriteria.meetCriteria(persons,
				type);

		for (Person person : otherCriteriaItems) {
			if (!firstCriteriaItems.contains(person)) {
				firstCriteriaItems.add(person);
			}
		}

		return firstCriteriaItems;
	}
}
