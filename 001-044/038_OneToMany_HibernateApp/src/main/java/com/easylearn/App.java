package com.easylearn;

import java.util.HashSet;
import java.util.Set;

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
		cfg.configure("/com/easylearn/hibernate.cfg.xml");
		
		SessionFactory sFactory = cfg.buildSessionFactory();
		Session session= sFactory.getCurrentSession();
		Transaction tx= session.beginTransaction();
		
		Users user1=new Users();
		user1.setFirstName("Tommy");
		user1.setLastName("Awe");
		user1.setUserId(1001);
		user1.setUserType("Student");
		
		PhoneNumbers phone1=new PhoneNumbers();
		phone1.setNumberType("Residence");
		phone1.setPhone(780956412);
		phone1.setUsers(user1);
		
		PhoneNumbers phone2=new PhoneNumbers();
		phone2.setNumberType("Office");
		phone2.setPhone(680956412);
		phone2.setUsers(user1);
		
		user1.getPhoneNumberses().add(phone1);
		user1.getPhoneNumberses().add(phone2);
		
		session.save(user1);
		
		Users user2=new Users();
		user2.setFirstName("Meghanath");
		user2.setLastName("MV");
		user2.setUserId(1002);
		user2.setUserType("Employee");
		
		Set<PhoneNumbers> phoneNumbers1=new HashSet<PhoneNumbers>();
		PhoneNumbers phone3=new PhoneNumbers();
		phone3.setNumberType("Residence");
		phone3.setPhone(480956412);
		phone3.setUsers(user2);
		phoneNumbers1.add(phone3);
		
		PhoneNumbers phone4=new PhoneNumbers();
		phone4.setNumberType("Office");
		phone4.setPhone(580956412);
		phone4.setUsers(user2);
		phoneNumbers1.add(phone4);
		
		user2.setPhoneNumberses(phoneNumbers1);
		session.save(user2);

		tx.commit();
		
    }
}
