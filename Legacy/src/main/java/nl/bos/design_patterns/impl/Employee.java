/**
 * 
 */
package nl.bos.design_patterns.impl;

import java.util.ArrayList;
import java.util.List;

import static nl.bos.design_patterns.IConstants.STR_OUTPUT_EMPLOYEE;

/**
 * @author bosa
 *
 */
public class Employee {
	private String name;
	private String dept;
	private int salary;
	private List<Employee> subordinates;
	
	public Employee(String name, String dept, int salary) {
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		subordinates = new ArrayList<Employee>();
	}
	
	public void add(Employee e) {
		subordinates.add(e);
	}
	
	public void remove(Employee e) {
		subordinates.remove(e);
	}
	
	public List<Employee> getSubordinates() {
		return subordinates;
	}
	
	public String toConsole() {
		return (String.format(STR_OUTPUT_EMPLOYEE, name, dept, salary));
	}
}
