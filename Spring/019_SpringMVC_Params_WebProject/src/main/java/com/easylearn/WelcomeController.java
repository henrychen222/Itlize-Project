package com.easylearn;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	@RequestMapping("/welcome/{first}/{last}/{hourrate}")
	public ModelAndView welcome(@PathVariable(value = "first") String firstName,
			@PathVariable(value = "last") String lastName, @PathVariable(value = "hourrate") @NumberFormat(style=Style.CURRENCY) Double perHour) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		mav.addObject("success", " Welcome to Spring Demo ::: firstName =" + firstName + "  ==> lastName =" + lastName
				+ " perHour=" + perHour);

		return mav;
	}

}
