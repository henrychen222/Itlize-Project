package com.easylearn;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class DataSourceConfig {

	static DataSource datasource = null;

	static JdbcTemplate jdbcTemplate = null;

	static {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/easylearn/spring-config.xml");
		datasource = (DataSource) context.getBean("mysqlDbConn");
	}

	public static JdbcTemplate getJdbcTemplate() {

		if (jdbcTemplate == null) {

			jdbcTemplate = new JdbcTemplate(datasource);

		}

		return jdbcTemplate;

	}

}
