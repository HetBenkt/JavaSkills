/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.STR_OUTPUT_IMAGE;
import static nl.bos.design_patterns.IConstants.STR_OUTPUT_STUDENT;

/**
 * @author bosa
 *
 */
public class StudentView {
	public void show() {
		System.out.println(String.format(STR_OUTPUT_IMAGE, this.getClass().getSimpleName()));
	}

	public void printStudentDetails(String name, String rollNo) {
		System.out.println(String.format(STR_OUTPUT_STUDENT, name, rollNo));
	}
}
