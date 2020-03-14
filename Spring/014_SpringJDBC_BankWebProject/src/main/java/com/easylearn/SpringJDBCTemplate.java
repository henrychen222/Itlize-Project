package com.easylearn;


import javax.sql.DataSource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;

public class SpringJDBCTemplate {
	private static DatasourceInter i1 = null;
	static {
		Resource res = new ClassPathResource("spring-config-bank.xml");
		BeanFactory factory = new XmlBeanFactory(res);
		i1 = (DatasourceInter) factory.getBean("mysqlDs");
	}

	public static JdbcTemplate getTemplate() {
		try {
			DataSource ds = i1.getDbConnection();
			return new JdbcTemplate(ds);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}