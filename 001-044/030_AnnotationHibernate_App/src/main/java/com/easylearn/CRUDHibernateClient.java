package com.easylearn;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * CRUD MYSQL Client
 *
 */
public class CRUDHibernateClient 
{
    @SuppressWarnings("unchecked")
	public static void main( String[] args )
    {
		Session session = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory().openSession();

		Transaction tx= session.beginTransaction();
		System.out.println("************* INSERT Operation :: POJO***********");
		Employee em = new Employee();
		em.setFirstName("Kris");
		em.setLastName("Kris");
		em.setMiddleName("Kris");
		em.setEmailId("Kris@gmail.com");
		em.setPhoneNumber("9876543210");
		em.setTxAddress("USA");
		session.save(em);
		
		System.out.println("************* SINGLE SELECT Operation :: POJO***********");
		Employee em1 = (Employee) session.get(Employee.class, new Integer(9));
		System.out.println(em1);
		
		System.out.println("************* UPDATE Operation :: POJO***********");
		session.evict(em1);
		em1.setLastName("Alvin5");
		session.saveOrUpdate(em1);
		
		System.out.println("************* DELETE Operation :: POJO***********");
		Employee emp2 = new Employee();
		emp2.setIdEmp(new Integer(24));
		session.delete(emp2);
		
		tx.commit();
		
		System.out.println("************* ALL SELECT Operation :: POJO***********");
		List<Employee> empList = session.createCriteria(Employee.class).list();

		for (Employee emp : empList) {
			System.out.println(emp);
		}
		
		session.close();
    }
}
