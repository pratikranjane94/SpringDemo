package com.sample.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.dto.Login;



//@Repository("loginDao")
public class LoginDaoImp implements LoginDao {

	@Resource(name = "sessionFactory")
	SessionFactory sessionFactory;
	Session session;

	// checking user name and password
	public boolean isValid(String username, String password) {
		session = sessionFactory.openSession();
		//System.out.println("Is valid"+username+" "+password);
		
		Query query = session.createQuery("from Login where username=? and password=?");
		query.setString(0, username);
		query.setString(1, password);
		
		List list=query.list();//getting hql result
		
		// checking result
		if (list!=null&&list.size()>0)
			return true;
		else
			return false;
	}

	//display list of user
	public List<Login> showList() {
		session=sessionFactory.openSession();
		Query query=session.createQuery("from Login");
		List list=query.list();
		return list;
	}

}
