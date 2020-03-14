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
		person.setPersonId(new Long(1001));
		session.save(person);

		Employeee employee = new Employeee("James", "Gosling", "Marketing", new Date());
		employee.setPersonId(new Long(1002));
		session.save(employee);

		Owner owner = new Owner("Bill", "Gates", 300L, 20L);
		owner.setPersonId(new Long(1003));
        session.save(owner);
        
		tx.commit();

	}
}
