package com.partnerconnect.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.partnerconnect.dao.UserDao;
import com.partnerconnect.exceprion.EmptyException;
import com.partnerconnect.exceprion.NotValidUserException;
import com.partnerconnect.model.Partner;
import com.partnerconnect.model.Critical;
import com.partnerconnect.model.Groups;
import com.partnerconnect.model.User;
import com.partnerconnect.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	@Override
	public User getUser(User user) throws NotValidUserException {
		return userDao.getUser(user);
	}

	@Override
	public List<Critical> getEmailInfo() {
		return userDao.getEmailInfo();
	}

	@Override
	public Groups getGroupId( String name) {
        
		return userDao.getGroupID(name);
	}

	@Override
	public int savePartner(Partner addPartner) {
return userDao.savePartner(addPartner);		
	}

	@Override
	public List<Partner> partnersList()  {
		// TODO Auto-generated method stub
		return userDao.partnersList();
	}

	@Override
	public Partner getPartner(String name) {
		return userDao.getPartner(name);
	}

	@Override
	public void deletePartner(int id) {
userDao.deletePartner(id);		
	}


}
