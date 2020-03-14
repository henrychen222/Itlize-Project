import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateTable {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con= null;
		Statement st =null;
		String sql = "CREATE TABLE EMPLOYEE(ID_EMP integer NOT NULL auto_increment," +
				"FIRST_NAME varchar(40)," +
				"LAST_NAME varchar(40)," +
				"MIDDLE_NAME varchar(30)," +
				"PHONE_NUMBER varchar(10)," +
				"EMAIL_ID varchar(265)," +
				"TX_ADDRESS varchar(268)," +
				"PRIMARY KEY (ID_EMP))";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java_weekend_batch1", "root", "admin");
			st=con.createStatement();
			System.out.println(sql);
			int result = st.executeUpdate(sql);
			System.out.println("Table is created successfully......!!!!"+result);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(con!=null)
				con.close();
			if(st!=null)
				st.close();
		}
	}
}
