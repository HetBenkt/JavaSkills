/**
 * 
 */
package nl.bos.design_patterns;

import java.util.List;

import nl.bos.design_patterns.impl.Person;

/**
 * @author bosa
 *
 */
public interface ICriteria {
	public List<Person> meetCriteria(List<Person> persons, String type);
}
