package com.partnerconnect.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.partnerconnect.dao.UserDao;
import com.partnerconnect.exceprion.NotValidUserException;
import com.partnerconnect.model.Partner;
import com.partnerconnect.model.Critical;
import com.partnerconnect.model.Groups;
import com.partnerconnect.model.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public User getUser(User user) throws NotValidUserException {
		String userQuery = "from User where userName=:userName and password=:password";
		Query query = getCurrentSession().createQuery(userQuery);
		query.setParameter("userName", user.getUserName());
		query.setParameter("password", user.getPassword());
		List<User> list = query.list();
		if (list != null && list.size() > 0) {
			for (User userName : list) {
				return list.get(0);
			}
		} else {
			throw new NotValidUserException("Invalid User");
		}
		return null;
	}

	@Override
	public List<Critical> getEmailInfo() {
		Query query = getCurrentSession().createQuery("from Critical");
		List<Critical> list = query.list();
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	@Override
	public Groups getGroupID(String name) {
		Query query = getCurrentSession().createQuery("from Groups");
		List<Groups> list = query.list();
		System.out.println(name + "" + list);
		if (list != null && list.size() > 0) {
			int n = list.size();
			for (int i = 0; i < n; i++) {
				System.out.println(list.get(i).getName());
				if (name.equals((list.get(i).getName()))) {
					System.out.println(list.get(i));
					return list.get(i);

				}
			}
		}
		return null;
	}

	@Override
	public int savePartner(Partner partner) {

		if(partner!=null&&partner.getId()==0){
			Session session = getCurrentSession();
			session.saveOrUpdate(partner);
			return partner.getId();
			}
		else{
			Query query=getCurrentSession().createQuery("from Partner where id=:id");
			query.setParameter("id", partner.getId());
			Partner partnerResult=(Partner) query.list().get(0);
			partnerResult.setId(partner.getId());
			partnerResult.setPartnerName(partner.getPartnerName());
			partnerResult.setGroup(partner.getGroup());
			partnerResult.setStreetAddress(partner.getStreetAddress());
			partnerResult.setCity(partner.getCity());
			partnerResult.setState(partner.getState());
			partnerResult.setZipCode(partner.getZipCode());
			Session session = getCurrentSession();
			session.saveOrUpdate(partnerResult);
				
		}
		return 0;
		
			
		
	}

	

	@Override
	public List<Partner> partnersList() {
		Criteria criteria = getCurrentSession()
				.createCriteria(Partner.class);
		List<Partner> list = criteria.list();
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;

	}

	@Override
	public Partner getPartner(String name) {
String query=" from  Partner where partnerName=:name";
Query queryResult=getCurrentSession().createQuery(query);
queryResult.setParameter("name",name);
Partner partner=(Partner) queryResult.list().get(0);
		return partner;
	} 

	@Override
	public void deletePartner(int id) {
	Query query=getCurrentSession().createQuery("delete from Partner where id=:id");
	query.setParameter("id", id);	
	query.executeUpdate();
	
		
	}

}
