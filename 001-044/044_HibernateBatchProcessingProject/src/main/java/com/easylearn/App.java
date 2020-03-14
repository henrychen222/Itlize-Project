package com.easylearn;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration();
		cfg.configure("/com/easylearn/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		System.out.println("*********INSERT a record into the EMP Table*********************");
		for (int i = 1; i < 100000; i++) {
			Employee em = new Employee();
			em.setNmFirst("Richard"+i);
			em.setNmLast("Alvin"+i);
			em.setNmMid("Kris"+i);
			em.setAmSalary(8956.65*i);
			em.setDtBirth(new Date());
			em.setTxAddress("USA");
			int idEmp = (Integer) session.save(em);
			System.out.println("EMPID=="+idEmp +" =====>"+     em);
			
			if(i % 100 == 0){
				session.flush();
				session.clear();
				System.out.println("*********************   SESSSION FLUSHED SUCCESSFULLY AFTER i="+i +"***********************");
			}
		}
		tx.commit();
		session.close();
    }
}
