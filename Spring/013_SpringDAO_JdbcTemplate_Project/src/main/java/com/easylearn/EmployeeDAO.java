package com.easylearn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Spring JDBC - DAO Module
 *
 */
public class EmployeeDAO {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("/com/easylearn/spring-config.xml");

		JdbcTemplate jt = DatabaseManager.getJdbcTemplate();
		int empCount = jt.queryForObject("SELECT COUNT(*) FROM EMPLOYEE", Integer.class);
		System.out.println("Total Employee Count == " + empCount);

		JdbcTemplate jt1 = DatabaseManager.getTemplate();

		String empCount1 = jt1.queryForObject("SELECT SUM(PHONENUMBER) FROM EMPLOYEE", String.class);

		System.out.println("Total Employee Count == " + empCount1);

	}
}
