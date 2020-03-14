package com.easylearn.mysql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDBConnector {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_weekend_batch1", "root", "admin");
			
			if(con != null){
				
				DatabaseMetaData metaData = con.getMetaData();
				System.out.println(metaData.getDatabaseProductName());
				System.out.println(metaData.getSQLKeywords());
				
				System.out.println("JAVA ---> MySQL Connection is established successfully......");
			}else{
				System.out.println("JAVA ---> MySQL Connection is failed to establish......");
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("JAVA ---> MySQL Connection is failed to establish......");
			e.printStackTrace();
		} finally {
			con.close();
		}

	}

}
