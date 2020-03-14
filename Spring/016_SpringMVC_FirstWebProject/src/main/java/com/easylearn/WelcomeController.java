package com.easylearn;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class WelcomeController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView mav = new ModelAndView("/WEB-INF/views/welcome.jsp");

		mav.addObject("message", "Welcome to Spring MVC Framework.....!!!!");

		return mav;
	}

}
