package com.easylearn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringClient {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("/com/easylearn/spring-config.xml");
		
		System.out.println("ApplicationContext Container is ready to use...!!!");

		DemoBeanInter obj = (DemoBeanInter) context.getBean("demoObj");

		obj.getCurrentDateAndTime();

		String result = obj.wish("Rod Jhonson");

		System.out.println(result);
		
		//second call
		DemoBeanInter obj1 = (DemoBeanInter) context.getBean("demoObj");

		obj1.getCurrentDateAndTime();

	}

}
