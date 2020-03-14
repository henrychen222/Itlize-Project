package com.easylearn;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginGET(@RequestParam(name="user") String userName, @RequestParam(required=false) String password, Model model) {

		model.addAttribute("success", "You are logged in successfully using (UserName ="+ userName+ " <==> Password ="+ password+ ").....GET......!!!");

		return "login";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String loginPOST(@RequestParam(name="user") String userName, @RequestParam(required=false) String password, Model model) {

		model.addAttribute("success", "You are logged in successfully using (UserName ="+ userName+ " <==> Password ="+ password+ ").....POST......!!!");

		return "login";
	}

}
