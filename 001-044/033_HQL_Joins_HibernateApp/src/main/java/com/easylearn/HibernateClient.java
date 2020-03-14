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

		System.out.println("**************** HQL :  INNER JOIN Query *********************");
		List<Object[]> emp_dept_list = session.createQuery(" FROM Employee emp "
				+ "inner join emp.department "
				+ "WHERE emp.email LIKE '%gmail%' "
				+ "ORDER BY emp.id DESC ").list();
		for (Object[] emp_dept : emp_dept_list) {
			System.out.println(emp_dept[0] +" \t "+emp_dept[1]);
		}
		
		
		System.out.println("**************** HQL :  LEFT JOIN Query *********************");
		emp_dept_list = session.createQuery(" FROM Employee emp left join emp.department ").list();
		for (Object[] emp_dept : emp_dept_list) {
			System.out.println(emp_dept[0] +" \t "+emp_dept[1]);
		}
		
		System.out.println("**************** HQL :  RIGHT JOIN Query *********************");
		emp_dept_list = session.createQuery(" FROM Employee emp right join emp.department ").list();
		for (Object[] emp_dept : emp_dept_list) {
			System.out.println(emp_dept[0] +" \t "+emp_dept[1]);
		}
		
		System.out.println("************************Employee to Department  ****************************");

		List<Employee> emp_list = session.createQuery(" FROM Employee emp").list();
		for (Employee emp_dept : emp_list) {
			System.out.println(emp_dept + " dept==>"+emp_dept.getDepartment());
		}
		
		System.out.println("************************Department to Employee****************************");
		List<Department> dept_list = session.createQuery(" FROM Department emp").list();
		for (Department emp_dept : dept_list) {
			System.out.println(emp_dept + " dept==>"+emp_dept.getEmployees());
		}


	}
}
