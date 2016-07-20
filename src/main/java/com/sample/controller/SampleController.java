package com.sample.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.dao.LoginDaoImp;
import com.sample.dto.Login;

@Controller//("abc")
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
	public String redirect(@Valid @ModelAttribute("validate") Login login, BindingResult result) {
		String username = login.getUsername();
		String password = login.getPassword();
		System.out.println(username+" "+password);
		
		if(result.hasErrors()){
			System.out.println("errorfound");
			return "login";
		}
		
		boolean found=loginDaoImp.isValid(username, password);
	
		if (loginDaoImp.isValid(username, password))
			return "success";
		else
			return "error";
	}
	@RequestMapping(value="list",method=RequestMethod.GET)
	public String showList()
	{
		List list=loginDaoImp.showList();
		return "login";
		
	}

}
