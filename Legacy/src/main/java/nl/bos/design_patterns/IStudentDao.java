/**
 * 
 */
package nl.bos.design_patterns;

import nl.bos.design_patterns.impl.StudentModel;

import java.util.List;

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
