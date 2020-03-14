package com.easylearn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstLevlCacheApp 
{
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration();
		cfg.configure("/com/easylearn/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		System.out.println("==========FIRST LEVEL CACHE============*****SELECT a record from the EMP Table*********************");
		Employee emp = (Employee) session.get(Employee.class, 104);
		System.out.println(emp);
		
		Employee emp1 = (Employee) session.get(Employee.class, 104);
		System.out.println(emp1);
		
		Session session1 = factory.openSession();
		Employee emp2 = (Employee) session1.get(Employee.class, 104);
		System.out.println(emp2);
		
    }
}
