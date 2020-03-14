package com.easylearn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAOPClient {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("/com/easylearn/spring-config.xml");
		CustomerBean customer = (CustomerBean) context.getBean("customer");
		customer.browseEmployee("Alvin");
		
		System.out.println();
		customer.browseEmployee();
		System.out.println();

		customer.browseStudent();
		System.out.println();

		
		OwnerBean owner = (OwnerBean) context.getBean("owner");
		owner.browseOwner("Ugo");

	}

}
