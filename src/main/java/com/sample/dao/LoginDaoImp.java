package com.sample.dao;

import java.util.List;

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
		System.out.println("Is valid"+username+" "+password);
		Query query = session.createQuery("from Login where username=?");
		query.setString(0, username);
		//query.setString(1, password);
		List list=query.list();
		//int result = query.executeUpdate();
		
		// checking result
		if (list!=null&&list.size()>0)
			return true;
		else
			return false;
	}

}
