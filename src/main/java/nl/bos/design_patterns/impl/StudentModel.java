/**
 * 
 */
package nl.bos.design_patterns.impl;

/**
 * @author bosa
 *
 */
public class StudentModel {
	private String rollNo;
	private String name;

	public StudentModel() {
	};

	public StudentModel(String name, String rollNo) {
		this.name = name;
		this.rollNo = rollNo;
	};

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
