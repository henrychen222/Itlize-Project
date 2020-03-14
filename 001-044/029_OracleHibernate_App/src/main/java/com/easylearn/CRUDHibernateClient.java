package com.easylearn;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * CRUD ORACLE Client
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
		em.setNmFirst("Kris");
		em.setNmLast("Kris");
		em.setNmMid("Kris");
		em.setAmSalary(new Double("9876.50"));
		em.setDtJoin(new Date());
		em.setTxAddress("USA");
		session.save(em);
		
		System.out.println("************* SINGLE SELECT Operation :: POJO***********");
		Employee em1 = (Employee) session.get(Employee.class, new BigDecimal(102));
		System.out.println(em1);
		
		System.out.println("************* UPDATE Operation :: POJO***********");
		em1.setDtJoin(new Date());		session.update(em1);
		
		System.out.println("************* DELETE Operation :: POJO***********");
		Employee emp2 = new Employee();
		emp2.setIdEmp(new BigDecimal(101));
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
