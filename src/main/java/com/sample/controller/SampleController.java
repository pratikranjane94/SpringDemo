package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.dao.LoginDaoImp;
import com.sample.dto.Login;

@Controller
public class SampleController {
	@Autowired
	LoginDaoImp loginDaoImp;

	@RequestMapping(value = "sample.html", method = RequestMethod.GET)
	public String demo() {
		return "hello";
	}

	@RequestMapping(value = "loginpage", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String redirect(@ModelAttribute("login") Login login, BindingResult result) {
		String username = login.getUsername();
		String password = login.getPassword();
		
		boolean found=loginDaoImp.isValid(username, password);
		System.out.println(username+" "+password+" "+found);
		if (loginDaoImp.isValid(username, password))
			return "success";
		else
			return "error";

	}

}
