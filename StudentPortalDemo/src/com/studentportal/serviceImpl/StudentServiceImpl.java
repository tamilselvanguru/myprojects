package com.studentportal.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentportal.dao.StudentDAO;
import com.studentportal.model.Student;
import com.studentportal.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDAO studentDAO;

	@Override
	public void updateStudent(Student student) {
		studentDAO.updateStudent(student);
	}

	@Override
	public List<Student> getStudentList() {
		return studentDAO.getStudentList();
	}

	@Override
	public void deleteStudent(int id) {
studentDAO.deleteStudent(id);		
	}

}
