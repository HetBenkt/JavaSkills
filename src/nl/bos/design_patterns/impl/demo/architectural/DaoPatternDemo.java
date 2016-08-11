/**
 * Data Access Object Pattern or DAO pattern is used to separate low level data accessing API or operations from high level business services.
 * ARCHITECTURAL
 * http://www.tutorialspoint.com/design_pattern/
 */
package nl.bos.design_patterns.impl.demo.architectural;

import static nl.bos.design_patterns.IConstants.STR_EMPTY;
import static nl.bos.design_patterns.IConstants.STR_LORA;
import static nl.bos.design_patterns.IConstants.STR_OUTPUT_NO_OBJECT;
import static nl.bos.design_patterns.IConstants.STR_OUTPUT_STUDENT;
import static nl.bos.design_patterns.IConstants.STR_SEPERATOR;

import nl.bos.design_patterns.impl.StudentDao;
import nl.bos.design_patterns.impl.StudentModel;

/**
 * @author bosa
 *
 */
public class DaoPatternDemo {

	private static StudentDao studentDao = new StudentDao();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		showAllStudents();

		StudentModel student = studentDao.getStudent("23221");
		if (student != null) {
			student.setName(STR_LORA);
			student.setRollNo("23233");
			studentDao.updateStudent(student);
			showAllStudents();
		} else {
			System.out.println(STR_OUTPUT_NO_OBJECT);
			System.out.println(String.format(STR_SEPERATOR, STR_EMPTY));
		}

		student = studentDao.getStudent("23233");
		if (student != null) {
			studentDao.deleteStudent(student);
			showAllStudents();
		} else {
			System.out.println(STR_OUTPUT_NO_OBJECT);
			System.out.println(String.format(STR_SEPERATOR, STR_EMPTY));
		}
	}

	private static void showAllStudents() {
		for (StudentModel student : studentDao.getAllStudents()) {
			System.out.println(String.format(STR_OUTPUT_STUDENT, student.getName(), student.getRollNo()));
		}
		System.out.println(String.format(STR_SEPERATOR, STR_EMPTY));
	}
}