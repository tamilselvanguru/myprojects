package com.studentportal.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.studentportal.dao.StudentDAO;
import com.studentportal.model.Address;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getStudentList() {
		Criteria criteria = getCurrentSession().createCriteria(Student.class);
		List<Student> list = new ArrayList<Student>();
		list = criteria.list();
		if (list != null && list.size() > 0) {
		}
		return list;
	}

	@Override
	public void deleteStudent(int id) {
		Query query=getCurrentSession().createQuery("  delete from Student where studentID=:id");
		query.setParameter("id", id);
		System.out.println("inside query");
	query.executeUpdate();
	int query2=getCurrentSession().createQuery("delete from Address where studentID="+id).executeUpdate();
	int query3=getCurrentSession().createQuery("delete from Marks where studentID="+id).executeUpdate();
	}

}
