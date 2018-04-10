/**
 * 
 */
package nl.bos.design_patterns.impl;

import java.util.List;

import nl.bos.design_patterns.ICriteria;

/**
 * @author bosa
 *
 */
public class AndCriteria implements ICriteria {

	private ICriteria criteria;
	private ICriteria otherCriteria;

	public AndCriteria(ICriteria criteria, ICriteria otherCriteria) {
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
		List<Person> firstCriteriaPersons = criteria.meetCriteria(persons, type);
		return otherCriteria.meetCriteria(firstCriteriaPersons, type);
	}
}
