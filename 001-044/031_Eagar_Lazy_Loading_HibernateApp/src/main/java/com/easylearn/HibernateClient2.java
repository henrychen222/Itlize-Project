package com.easylearn;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 * Eagar Loading: session.get()
 * Lazy Loading : session.load()
 */
public class HibernateClient2 {
	
	public static void main(String[] args) {

		Session session = new Configuration().configure().buildSessionFactory().openSession();
		session.beginTransaction();

		
		System.out.println("**************** Eagar Loading :  session.get()*********************");
		Employee emp1= session.get(Employee.class, 10001);
		System.out.println(emp1);
		
		System.out.println("**************** Lazy Loading :  session.load()*********************");
		Employee emp2= session.load(Employee.class, 10004);
		System.out.println(emp2);
		
	}
}
