package com.easylearn;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 * HQL
 */
public class HibernateClient {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = new Configuration().configure().buildSessionFactory().openSession();
		session.beginTransaction();

		System.out.println("**************** HQL :  from query *********************");
		List<Employee> empList = session.createQuery(" FROM Employee").list();
		for (Employee emp1 : empList) {
			System.out.println(emp1);
		}
		
		
		System.out.println("**************** HQL :  where query *********************");
		empList = session.createQuery(" FROM Employee WHERE amSalary >= 15000 "
				+ "AND nmMid IS NOT NULL "
				+ "AND nmLast like 'G%'"
				+ "ORDER BY idEmp DESC")
				//.setMaxResults(5)
				.list();
		for (Employee emp1 : empList) {
			System.out.println(emp1);
		}
		
		System.out.println("**************** HQL :  Aggrigate Functions : SUM() *********************");
		Double totalSalary = (Double) session.createQuery(" SELECT sum(amSalary) FROM Employee").getSingleResult();
		System.out.println(" Total salary paid by the company : "+totalSalary);
		
		System.out.println("**************** HQL :  Aggrigate Functions : COUNT() *********************");
		Long totalEmployees = (Long) session.createQuery(" SELECT count(idEmp) FROM Employee").getSingleResult();
		System.out.println(" Total Employees in the company : "+totalEmployees);
		
		System.out.println("**************** HQL :  Aggrigate Functions : MAX() *********************");
		Double maxSalary = (Double) session.createQuery(" SELECT max(amSalary) + min(amSalary) FROM Employee").getSingleResult();
		System.out.println(" Total salary paid in the company : "+maxSalary);


	}
}
