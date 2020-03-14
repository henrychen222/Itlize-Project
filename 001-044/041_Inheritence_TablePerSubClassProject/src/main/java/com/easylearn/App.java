package com.easylearn;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		/** Steps to Activate Hibernate Framework **/
		Configuration cfg = new Configuration();
		cfg.configure("/hibernate.cfg.xml");

		SessionFactory sFactory = cfg.buildSessionFactory();
		Session session = sFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Person person = new Person("Steve", "Balmer");
		session.save(person);

		Employeee employee = new Employeee("James", "Gosling", "JAVA", new Date());
		session.save(employee);

		Owner owner = new Owner("Bill", "Gates", 300L, 20L);
        session.save(owner);
        
		Student stu=new Student("Neha", "Neha", "Spring-Hibernate", new Date());
		session.save(stu);
        
		tx.commit();

	}
}
