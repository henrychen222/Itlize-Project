package com.easylearn;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("unchecked")
public class QueryLevelCacheApp 
{
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration();
		cfg.configure("/com/easylearn/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		System.out.println("*********Query Level Cache*********************");
		
		List<Employee> empList = session.createQuery("from Employee as e where (amSalary<15000 or txAddress like '%USA%') order by idEmp desc")
				.setCacheable(true)
				.setMaxResults(5)
				.list();

		for (Employee emp : empList) {
			System.out.println(emp);
		}
		tx.commit();

		Session session1 = factory.getCurrentSession();
		Transaction tx1 = session1.beginTransaction();
		List<Employee> empList1 = session1.createQuery("from Employee as e where (amSalary<15000 or txAddress like '%USA%') order by idEmp desc")
				.setCacheable(true)
				.setMaxResults(5)
				.list();

		for (Employee emp : empList1) {
			System.out.println(emp);
		}
		tx1.commit();

		
    }
}
