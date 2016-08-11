/**
 * 
 */
package nl.bos.design_patterns.impl;

/**
 * @author bosa
 *
 */
public class StudentController {
	private StudentModel studentModel;
	private StudentView studentView;

	public StudentController(StudentModel studentModel, StudentView studentView) {
		this.studentModel = studentModel;
		this.studentView = studentView;
	}

	public void setStudentName(String name) {
		studentModel.setName(name);
	}

	public String getStudentName() {
		return studentModel.getName();
	}

	public void setStudentRollNo(String rollNo) {
		studentModel.setRollNo(rollNo);
	}

	public String getStudentRollNo() {
		return studentModel.getRollNo();
	}

	public void updateView() {
		studentView.printStudentDetails(studentModel.getName(), studentModel.getRollNo());
	}
}
