package com.easylearn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SecondLevlCacheApp 
{
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration();
		cfg.configure("/com/easylearn/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		System.out.println("==========SECOND LEVEL CACHE============*****SELECT a record from the EMP Table*********************");
		Employee emp = (Employee) session.get(Employee.class, 107);
		System.out.println(emp);
		tx.commit();

		Session session1 = factory.getCurrentSession();
		Transaction tx1 = session1.beginTransaction();
		Employee emp1 = (Employee) session1.get(Employee.class, 107);
		System.out.println(emp1);
		tx1.commit();

		
    }
}
