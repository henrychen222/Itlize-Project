import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class GetDBResults {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_weekend_batch1","root", "admin");
			Statement st = con.createStatement();
			
			ResultSet rs= st.executeQuery("SELECT * FROM EMPLOYEE");
			while(rs.next()){
				System.out.println(rs.getRow()+"\t " +rs.getInt("ID_EMP")+"\t "+rs.getString(2)+"\t "+rs.getString(3)+"\t "+rs.getString(4)+"\t "+rs.getString(5)+"\t "+rs.getString(6)+"\t "+rs.getString(7));
			}
			rs.close();
			st.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
