/**
 * 
 */
package nl.bos.design_patterns;

import nl.bos.design_patterns.impl.Person;

import java.util.List;

/**
 * @author bosa
 *
 */
public interface ICriteria {
	public List<Person> meetCriteria(List<Person> persons, String type);
}
