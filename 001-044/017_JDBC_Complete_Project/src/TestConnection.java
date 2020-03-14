import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;



public class TestConnection {

	public static void main(String[] args) {
		Connection con = null;
		try {

			//Class.forName("com.mysql.jdbc.Driver"); // oracle.jdbc.driver.OrcleDriver
			
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java_weekend_batch1", "root", "admin");

			if (con != null) {
				System.out.println("Connection is established  ");
				DatabaseMetaData metadata = con.getMetaData();
				System.out.println("Driver Version :"+ metadata.getDriverVersion());
				System.out.println("UserName : " + metadata.getUserName());
				System.out.println("URL :" + metadata.getURL());
				System.out.println("Keywords :" + metadata.getSQLKeywords());
			} else {
				System.out.println("Connection is not established");
			}
			
		} catch (Exception e) {
			System.out.println("Connection is not established  ");
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
