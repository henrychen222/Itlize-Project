package com.easylearn.oracle;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleDBConnector {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "system", "admin");
			
			if(con != null){
				
				DatabaseMetaData metaData = con.getMetaData();
				System.out.println(metaData.getDatabaseProductName());
				System.out.println(metaData.getSQLKeywords());
				
				System.out.println("JAVA ---> Oracle Connection is established successfully......");
			}else{
				System.out.println("JAVA ---> Oracle Connection is failed to establish......");
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("JAVA ---> Oracle Connection is failed to establish......");
			e.printStackTrace();
		} finally {
			con.close();
		}

	}

}
