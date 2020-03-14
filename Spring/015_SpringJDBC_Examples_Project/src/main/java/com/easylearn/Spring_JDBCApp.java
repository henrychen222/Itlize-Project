package com.easylearn;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Spring_JDBCApp {

	public static void main(String[] args) {

		JdbcTemplate jt = DataSourceConfig.getJdbcTemplate();

		int totEmpCount = jt.queryForInt("SELECT COUNT(*) FROM EMPLOYEE");

		System.out.println("Total Employees count = " + totEmpCount);

		System.out.println("==========SELECT THE EMPLOYEE REOCRD============");

		SqlRowSet rs = jt.queryForRowSet("SELECT * FROM EMPLOYEE WHERE ID=?", new Object[]{13});

		while (rs.next()) {

			System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));

		}
		

	}

}
