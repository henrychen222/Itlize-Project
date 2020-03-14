package com.dev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dev.service.HelloWorldService;

@Controller
public class HelloWorldController {
	
	@Autowired
	HelloWorldService helloWorldService;
	
	   @RequestMapping("/helloworld")
	   public ModelAndView helloWord(){
		      //service methods.
		      System.out.println("HelloWorldController is called..");
		       String mes=helloWorldService.findHelloService();
		      return new ModelAndView("helloworld", "message",mes);
	   }
	   
  }
