package com.easylearn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class RowMapperExample {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		JdbcTemplate jt = DataSourceConfig.getJdbcTemplate();

		System.out.println("==========SELECT THE EMPLOYEE REOCRD============");
		Employee emp = (Employee) jt.queryForObject("SELECT * FROM EMPLOYEE WHERE ID=?", new Object[] { 13 }, new RowMapper() {
					public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
						Employee emp = new Employee();
						emp.setEmpId(rs.getInt(1));
						emp.setFirstName(rs.getString(2));
						emp.setLastName(rs.getString(3));
						emp.setEmail(rs.getString(4));
						emp.setPhone(rs.getLong(5));
						return emp;
					}
				});
		
		System.out.println(emp);
		
		System.out.println("==========SELECT ALL EMPLOYEES ============");
		List<Employee> empList = (List<Employee>) jt.query("SELECT * FROM EMPLOYEE", new RowMapper() {
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee emp = new Employee();
				emp.setEmpId(rs.getInt(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setEmail(rs.getString(4));
				emp.setPhone(rs.getLong(5));
				return emp;
			}
		});

		for (Employee employee : empList) {
			System.out.println(employee);
		}
	}

}
