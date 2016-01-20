package com.studentportal.service;

import java.util.List;

import com.studentportal.model.Student;

public interface StudentService {
	public void updateStudent(Student student);

	public List<Student> getStudentList();
	public void deleteStudent(int id);
}
