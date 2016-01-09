package com.studentportal.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.studentportal.model.Address;
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
		studentService.updateStudent(student);
		Map<String, String> map = new HashMap<String, String>();
		map.put("response", "successfully added");
		return map;

	}

}