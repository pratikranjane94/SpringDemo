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

@Controller // ("abc")
public class SampleController {
	@Autowired
	LoginDaoImp loginDaoImp;

	// redirect to success page from index
	@RequestMapping(value = "push", method = RequestMethod.GET)
	public String demo() {
		return "success";
	}

	// redirect to login page from index
	@RequestMapping(value = "loginpage", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	// checking username and password
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String redirect(@Valid @ModelAttribute("validate") Login login, BindingResult result) {
		
		// validation
		if (result.hasErrors()) { 
			System.out.println("errorfound");
			return "login";
		} else {
			if (loginDaoImp.isValid(login.getUsername(),login.getPassword())) // if username and password matched
															
				return "success";
			else
				return "error";
		}
	}

	// displaying all users
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String showList(Model model) {
		model.addAttribute("list", loginDaoImp.showList());
		model.addAttribute("login", new Login());
		return "list";

	}

	// delete user by id
	@RequestMapping(value = "list/delete/{id}", method = RequestMethod.GET)
	public String delete(@ModelAttribute("delete/{id}") Login login, BindingResult result, Model model) {
		System.out.println("Id:" + login.getId());
		List list = loginDaoImp.delete(login.getId()); // user deleted

		if (list != null || list.size() > 0) {
			model.addAttribute("list", list);
			return "list";
		} else
			return "error";
	}

}
