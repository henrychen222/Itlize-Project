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

		Employee employee = new Employee("James", "Gosling", "JAVA", new Date());
		session.save(employee);

		tx.commit();

	}
}
