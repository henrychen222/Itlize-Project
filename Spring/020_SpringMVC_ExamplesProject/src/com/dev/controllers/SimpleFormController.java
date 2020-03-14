package com.dev.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dev.form.UserForm;

@Controller
public class SimpleFormController {
	   
	@RequestMapping(value = "/simpleForm.do", method = RequestMethod.POST)
	public void simpleForm(Model model) {
		UserForm user = new UserForm();
		user.setUserName("john");
		user.setEmail("john@gmail.com");
		   model.addAttribute(user);
		   System.out.println("/simpleForm.html POST URL is called.....");
		  // return new ModelAndView("simpleForm", "user",user);
	  }
	
	@RequestMapping(value = "/simpleForm.do", method = RequestMethod.GET)
	public void simpleForm1(Model model) {
		UserForm user = new UserForm();
   	   model.addAttribute(user);
		   System.out.println("/simpleForm.html GET URL is called.....");
		  // return new ModelAndView("simpleForm", "user",user);
	  }
	
	
	@RequestMapping(value = "/formoutput.do", method = RequestMethod.POST)
	public void simple(@ModelAttribute UserForm user, Model model) {
		   model.addAttribute("user", user);	
		   System.out.println("/formoutput.html POST URL is called.....");

	}
	
	@RequestMapping(value = "/formoutput.do", method = RequestMethod.GET)
	public void simple1(@ModelAttribute UserForm user, Model model) {
		   model.addAttribute("user", user);	
		   System.out.println("/formoutput.html GET URL is called.....");

	}
}
