/**
 * MVC Pattern stands for Model-View-Controller Pattern. This pattern is used to separate application's concerns.
 * ARCHITECTURAL
 * http://www.tutorialspoint.com/design_pattern/
 */
package nl.bos.design_patterns.impl.demo.architectural;

import nl.bos.design_patterns.impl.StudentController;
import nl.bos.design_patterns.impl.StudentModel;
import nl.bos.design_patterns.impl.StudentView;

import static nl.bos.design_patterns.IConstants.*;

/**
 * @author bosa
 *
 */
public class MVCPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StudentModel model = retriveStudentFromDatabase();
		StudentView view = new StudentView();
		StudentController controller = new StudentController(model, view);

		controller.updateView();
		controller.setStudentName(STR_JOHN);
		controller.updateView();
	}

	private static StudentModel retriveStudentFromDatabase() {
		StudentModel student = new StudentModel();
		student.setName(STR_ROBERT);
		student.setRollNo(STR_TEN);
		return student;
	}
}
