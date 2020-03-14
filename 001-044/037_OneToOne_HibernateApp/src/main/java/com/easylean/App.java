package com.easylean;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	/** Steps to Activate Hibernate Framework **/
		Configuration cfg=new Configuration();
		cfg.configure("/com/easylean/hibernate.cfg.xml");
		
		SessionFactory sFactory = cfg.buildSessionFactory();
		Session session= sFactory.getCurrentSession();
		Transaction tx= session.beginTransaction();
		
		Student st1=new Student();
		st1.setNmStudent("Vicky");
		st1.setPhNumber("5807894562");
		st1.setTxCourse("Spring");
		st1.setTxAddress("USA");
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.YEAR, 1986);
		st1.setDtBirth(cal.getTime());

		Library lib=new Library();
		lib.setStudent(st1);
		lib.setDtAlloted(new Date());
		lib.setDtReturn(new Date());
		lib.setNmBook("Spring In Action");

		session.save(st1);
		session.save(lib);
		
		session.flush();
		
		/** Select Student & Library Records **/
		
		System.out.println("*****************************Parent to Child******************");
		List<Student> studentList = session.createQuery("from Student").list();
		for (Student student : studentList) {
			System.out.println(student);
			System.out.println(student.getLibrary());
		}
		
		System.out.println("*****************************Child to Parent ******************");
		List<Library> libList = session.createQuery("from Library").list();
		for (Library library : libList) {
			System.out.println(library);
			System.out.println(library.getStudent());
		}
		tx.commit();

    }
}
