/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.STR_JOHN;
import static nl.bos.design_patterns.IConstants.STR_JULIE;
import static nl.bos.design_patterns.IConstants.STR_MSG_DEBUG;
import static nl.bos.design_patterns.IConstants.STR_MSG_INFO;

import java.util.ArrayList;
import java.util.List;

import nl.bos.design_patterns.IStudentDao;

/**
 * @author Fam. Bos
 *
 */
public class StudentDao implements IStudentDao {
	// The simulated DB of students.
	private List<StudentModel> students;

	public StudentDao() {
		students = new ArrayList<StudentModel>();
		StudentModel student1 = new StudentModel(STR_JOHN, "23221");
		StudentModel student2 = new StudentModel(STR_JULIE, "44355");
		students.add(student1);
		students.add(student2);
	}

	@Override
	public List<StudentModel> getAllStudents() {
		return students;
	}

	@Override
	public StudentModel getStudent(String rollNo) {
		StudentModel result = null;
		for (StudentModel student : students) {
			if (student.getRollNo().equals(rollNo))
				result = student;
		}
		return result;
	}

	@Override
	public void updateStudent(StudentModel student) {
		for (StudentModel studentLoc : students) {
			if (studentLoc.getRollNo().equals(student.getRollNo())) {
				studentLoc.setName(student.getName());
				studentLoc.setRollNo(student.getRollNo());
			}
		}
	}

	@Override
	public void deleteStudent(StudentModel student) {
		for (StudentModel studentLoc : students) {
			if (studentLoc.getRollNo().equals(student.getRollNo()))
				students.remove(student);
		}
	}
}
