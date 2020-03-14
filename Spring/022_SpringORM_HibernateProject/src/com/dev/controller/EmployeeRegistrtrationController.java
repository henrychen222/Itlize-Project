package com.dev.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dev.db.Employee;
import com.dev.service.EmployeeRegistrtrationService;
import com.dev.valueobject.EmployeeVO;

@Controller
public class EmployeeRegistrtrationController {

	@Autowired
	EmployeeRegistrtrationService empService;

	@RequestMapping(value = "/findEmployees.do")
	public ModelAndView getAllEmpList(@ModelAttribute("form1") @Valid Employee form1, BindingResult result, HttpServletRequest request) {
		
		ModelAndView mvn = new ModelAndView();
		
		EmployeeVO empVO = empService.getAllEmpList(form1);
		
		request.setAttribute("empList", empVO.getEmpList());
		
		if (form1.getCurrent_page() == 0) {
			form1.setTotalrecords(empVO.getEmpTotCount());
		}
		
		request.setAttribute("empForm", form1);
		
		mvn.setViewName("employeeslist");
		
		return mvn;
	}

}
