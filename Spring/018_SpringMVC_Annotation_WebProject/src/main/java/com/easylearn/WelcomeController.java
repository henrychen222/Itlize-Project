package com.easylearn;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	@RequestMapping("/welcome.do")
	public ModelAndView welcome() {

		ModelAndView mav = new ModelAndView("welcome");

		mav.addObject("message", "Welcome to Spring MVC Framework using Annotations.....!!!!");

		return mav;
	}

	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginGET(Model model) {

		model.addAttribute("success", "You are logged in successfully into this website.....GET......!!!");

		return "login";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String loginPOST(Model model) {

		model.addAttribute("success", "You are logged in successfully into this website.....POST...!!!");

		return "login";
	}

}
