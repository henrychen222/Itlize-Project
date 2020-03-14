package com.easylearn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JEE_JDBCApp {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/training_db", "root", "admin");

			st = con.createStatement();

			rs = st.executeQuery("SELECT * FROM EMPLOYEE");

			while (rs.next()) {

				System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				st.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
