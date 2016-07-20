package com.sample.dao;

import javax.annotation.Resource;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("loginDao")
public class LoginDaoImp implements LoginDao {

	@Resource(name = "sessionFactory")
	SessionFactory sessionFactory;
	Session session;

	// checking user name and password
	public boolean isValid(String username, String password) {
		session = sessionFactory.openSession();
		Query query = session.createQuery("from User o where o.username=? and o.password=?");
		query.setString(0, username);
		query.setString(1, password);
		int result = query.executeUpdate();
		
		// checking result
		if (result != 0 && result > 0)
			return true;
		else
			return false;
	}

}
