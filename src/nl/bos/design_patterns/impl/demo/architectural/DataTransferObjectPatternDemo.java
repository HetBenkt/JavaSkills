/**
 * The Data Transfer Object pattern is used when we want to pass data with multiple attributes in one shot from client to server. Transfer object is also known as Value Object (??). Transfer Object is a simple POJO class having getter/setter methods and is serializable so that it can be transferred over the network. It does not have any behavior. Server Side business class normally fetches data from the database and fills the POJO and send it to the client or pass it by value. For client, transfer object is read-only. Client can create its own transfer object and pass it to server to update values in database in one shot.
 * ARCHITECTURAL
 * http://www.tutorialspoint.com/design_pattern/
 */
package nl.bos.design_patterns.impl.demo.architectural;

import nl.bos.design_patterns.impl.StudentDao;
import nl.bos.design_patterns.impl.StudentModel;
import static nl.bos.design_patterns.IConstants.*;
/**
 * @author bosa
 *
 */
public class DataTransferObjectPatternDemo {
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
	}
	
	private static void showAllStudents() {
		for (StudentModel student : studentDao.getAllStudents()) {
			System.out.println(String.format(STR_OUTPUT_STUDENT, student.getName(), student.getRollNo()));
		}
		System.out.println(String.format(STR_SEPERATOR, STR_EMPTY));
	}
}