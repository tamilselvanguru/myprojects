package com.studentportal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.studentportal.model.Address;
import com.studentportal.model.Marks;
import com.studentportal.model.Student;
import com.studentportal.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, String> saveStudent(@RequestBody Student student) {
		System.out.println(student);
		Address address = student.getAddress();
		address.setStudent(student);
		Marks marks = student.getMarks();
		marks.setStudent(student);
		studentService.updateStudent(student);
		Map<String, String> map = new HashMap<String, String>();
		map.put("response", "successfully added");
		return map;

	}

	@RequestMapping(value = "/getStudentList", method = RequestMethod.GET)
	public @ResponseBody
	List<Student> getStudentList() {
		List<Student> list = studentService.getStudentList();

		return list;

	}

	@RequestMapping(value = "/deleteStudent", method = RequestMethod.DELETE)
	public @ResponseBody
	Map deleteStudent(@RequestBody int id) {
		System.out.println(id);
		Map map = new HashMap<>();
		studentService.deleteStudent(id);
		map.put("response", "deleted" + id + "successfully");
		return map;
	}
}