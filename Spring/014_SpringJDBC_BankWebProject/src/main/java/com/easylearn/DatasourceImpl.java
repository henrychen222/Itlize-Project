package com.easylearn;


import javax.sql.DataSource;

public class DatasourceImpl implements DatasourceInter {
	private DataSource dsource;

	public void setDsource(DataSource ds) {
		dsource = ds;
	}

	public DataSource getDbConnection() {
		return dsource;
	}
}