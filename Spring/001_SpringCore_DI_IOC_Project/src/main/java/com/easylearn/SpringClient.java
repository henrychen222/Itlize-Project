package com.easylearn;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SpringClient {

	public static void main(String[] args) {

		Resource res = new ClassPathResource("/com/easylearn/spring-config.xml");

		BeanFactory factory = new XmlBeanFactory(res);
		
		System.out.println("BeanFactory Container is ready to use...!!!");

		DemoBeanInter obj = (DemoBeanInter) factory.getBean("demoObj");

		obj.getCurrentDateAndTime();

		String result = obj.wish("Rod Jhonson");

		System.out.println(result);
		
		DemoBeanInter obj1 = (DemoBeanInter) factory.getBean("demoObj");

		obj1.getCurrentDateAndTime();

	}

}
