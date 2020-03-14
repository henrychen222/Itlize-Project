package com.easylearn;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class RowMapperAdvancedExample {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		JdbcTemplate jt = DataSourceConfig.getJdbcTemplate();

		System.out.println("==========SELECT THE EMPLOYEE REOCRD============");
		Employee emp = (Employee) jt.queryForObject("SELECT * FROM EMPLOYEE WHERE ID=?", new Object[] { 13 }, new EmployeeRowMapper());
		
		System.out.println(emp);
		
		System.out.println("==========SELECT ALL EMPLOYEES ============");
		List<Employee> empList = (List<Employee>) jt.query("SELECT * FROM EMPLOYEE",new EmployeeRowMapper());

		for (Employee employee : empList) {
			System.out.println(employee);
		}
	}

}
