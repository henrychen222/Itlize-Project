package com.easylearn;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringClient {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("/spring-config.xml");
		
		System.out.println("ApplicationContext Container is ready to use...!!!");
		
		EmployeeBean obj = (EmployeeBean) context.getBean("empObj");
		
		System.out.println(obj);
		
		EmployeeBean obj1 = (EmployeeBean) context.getBean("empBean");
		
		System.out.println(obj1);
		
		String[] aliases = context.getAliases("empObj");
		
		System.out.println(Arrays.asList(aliases));

	}

}
