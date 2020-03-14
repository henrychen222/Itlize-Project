package com.easylearn;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

/**
 * HQL
 */
public class CriteriaAPIJoinsClient {

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main(String[] args) {

		Session session = new Configuration().configure().buildSessionFactory().openSession();
		session.beginTransaction();

		System.out.println("**************** Criteria API :  INNER JOIN Query *********************");
		List<Employee_Shot> emp_list = session.createCriteria(Employee_Shot.class, "emp")
		.createAlias("department", "dept", JoinType.INNER_JOIN)
		.add(Restrictions.like("emp.email", "%gmail%"))
		.addOrder(Order.desc("emp.id"))
		.list();
		for (Employee_Shot emp_dept : emp_list) {
			System.out.println(emp_dept+" \t "+emp_dept.getDepartment());
		}
		
		System.out.println("**************** Criteria API : LEFT JOIN Query *********************");
		emp_list = session.createCriteria(Employee_Shot.class, "emp")
		.createAlias("department", "dept", JoinType.LEFT_OUTER_JOIN)
		.add(Restrictions.like("emp.email", "%gmail%"))
		.addOrder(Order.desc("emp.id"))
		.list();
		for (Employee_Shot emp_dept : emp_list) {
			System.out.println(emp_dept+" \t "+emp_dept.getDepartment());
		}
		
		System.out.println("**************** Criteria API :  RIGHT JOIN Query  *********************");
		emp_list = session.createCriteria(Employee_Shot.class, "emp")
		.createAlias("department", "dept", JoinType.RIGHT_OUTER_JOIN)
		.add(Restrictions.like("emp.email", "%gmail%"))
		.addOrder(Order.desc("emp.id"))
		
		.list();
		for (Employee_Shot emp_dept : emp_list) {
			if(emp_dept != null)
			System.out.println(emp_dept+" \t "+emp_dept.getDepartment());
		}

	}
}
