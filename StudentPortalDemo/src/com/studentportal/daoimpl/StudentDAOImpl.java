package com.studentportal.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.studentportal.dao.StudentDAO;
import com.studentportal.model.Student;

@Repository("studentDao")
@Transactional
public class StudentDAOImpl implements StudentDAO {
	@Autowired
	SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();

	}

	@Override
	public void updateStudent(Student student) {
		getCurrentSession().saveOrUpdate(student);
	}

}
