package com.partnerconnect.dao;

import java.util.List;

import com.partnerconnect.exceprion.EmptyException;
import com.partnerconnect.exceprion.NotValidUserException;
import com.partnerconnect.model.Partner;
import com.partnerconnect.model.Critical;
import com.partnerconnect.model.Groups;
import com.partnerconnect.model.User;
/*
 * User db changes
 */
public interface UserDao {
	public User getUser(User user) throws NotValidUserException;

	public List<Critical> getEmailInfo();

	public Groups getGroupID(String name);

	public int savePartner(Partner addPartner);

	public List<Partner> partnersList() ;
	public Partner getPartner(String name);
	public void deletePartner(int id);
}
