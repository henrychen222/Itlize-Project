package com.easylearn;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseManager {

	private static DataSource mysqlDs;
	private static JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public DataSource getMysqlDs() {
		return mysqlDs;
	}

	public void setMysqlDs(DataSource mysqlDs) {
		this.mysqlDs = mysqlDs;
	}

	public static JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(mysqlDs);
	}
	
	public static JdbcTemplate getTemplate() {
		return template;
	}
	

}
