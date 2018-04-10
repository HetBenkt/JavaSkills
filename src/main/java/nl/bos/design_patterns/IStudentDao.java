/**
 * 
 */
package nl.bos.design_patterns;

import java.util.List;

import nl.bos.design_patterns.impl.StudentModel;

/**
 * @author bosa
 *
 */
public interface IStudentDao {
	public List<StudentModel> getAllStudents();

	public StudentModel getStudent(String rollNo);

	public void updateStudent(StudentModel student);

	public void deleteStudent(StudentModel student);
}
