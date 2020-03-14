package com.easylearn;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 * Criteria API 
 */
public class CriteriaAPIClient {

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main(String[] args) {

		Session session = new Configuration().configure().buildSessionFactory().openSession();
		session.beginTransaction();

		System.out.println("**************** Criteria API :  from query *********************");
		List<Employee> empList = session.createCriteria(Employee.class)
				.setMaxResults(6)
				.list();
		for (Employee emp1 : empList) {
			System.out.println(emp1);
		}
		
		System.out.println("**************** Criteria API :  where query *********************");
		empList = session.createCriteria(Employee.class)
				.add(Restrictions.ge("amSalary", new Double(15000)))
				.add(Restrictions.isNotNull("lastName"))
				.add(Restrictions.like("email", "%gmail%"))
				.addOrder(Order.desc("id"))
				.addOrder(Order.asc("firstName"))
				.list();
		
		for (Employee emp1 : empList) {
			System.out.println(emp1);
		}
	
		
		System.out.println("**************** Criteria API :  Aggrigate Functions : SUM() *********************");
		Double totalSalary = (Double) session.createCriteria(Employee.class)
			.setProjection(Projections.sum("amSalary"))
			.uniqueResult();
		System.out.println(" Total salary paid by the company : "+totalSalary);
		
		System.out.println("**************** Criteria API :  Aggrigate Functions : COUNT() *********************");
		Long totalEmployees = (Long) session.createCriteria(Employee.class)
			.setProjection(Projections.count("id"))
			.uniqueResult();
		System.out.println(" Total Employees in the company : "+totalEmployees);
		
		System.out.println("**************** Criteria API :  Aggrigate Functions : MAX() *********************");
		Double maxSalary = (Double) session.createCriteria(Employee.class)
			.setProjection(Projections.max("amSalary"))
			.uniqueResult();
		System.out.println(" Total salary paid by the company : "+maxSalary);

	}
}
