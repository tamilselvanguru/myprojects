package com.studentportal.dao;

import java.util.List;

import com.studentportal.model.Student;

public interface StudentDAO {
	
	public void updateStudent(Student student);
	public List<Student> getStudentList();
	public void deleteStudent(int id);
		

}
