import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class InsertExample {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		Connection con=null;
		Statement st =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_weekend_batch1","root","admin");
			con.setAutoCommit(false);
			st = con.createStatement();
			
			String sql= "INSERT INTO EMPLOYEE (FIRST_NAME,LAST_NAME,MIDDLE_NAME,PHONE_NUMBER,EMAIL_ID,TX_ADDRESS) " +
					"VALUES ('Vijay','Vijay','Vijay','7788665123','Vijay@yahoo.com','PO BOX 469,Atlanta,GA,USA')";
			st.execute(sql);
			
			st.execute("INSERT INTO EMPLOYEE (FIRST_NAME,LAST_NAME,MIDDLE_NAME,PHONE_NUMBER,EMAIL_ID,TX_ADDRESS) " +
					"VALUES ('Declaro','Declaro','Declaro','8978964565','Declaro@yahoo.com','PO BOX 469,Atlanta,GA,USA')");
			
			System.out.println("Records are inserted successfully.");
			
			con.commit();
			
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
		}finally{
			if(con!=null)
				con.close();
			if(st!=null)
				st.close();
		}

	}

}
