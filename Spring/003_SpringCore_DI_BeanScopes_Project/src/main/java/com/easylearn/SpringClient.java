package com.easylearn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringClient {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("/com/easylearn/spring-config.xml");
		
		System.out.println("ApplicationContext Container is ready to use...!!!");

		System.out.println("*************** DemoBean Object1 is created****************");
		DemoBeanInter obj1 = (DemoBeanInter) context.getBean("demoObj");
		obj1.getCurrentDateAndTime();
		String result = obj1.wish("Rod Jhonson");
		System.out.println(result);

		
		System.out.println("*************** DemoBean Object2 is created****************");
		DemoBeanInter obj2 = (DemoBeanInter) context.getBean("demoObj1");
		obj2.getCurrentDateAndTime();
		String result1 = obj2.wish("Rod Jhonson");
		System.out.println(result1);

	}

}
