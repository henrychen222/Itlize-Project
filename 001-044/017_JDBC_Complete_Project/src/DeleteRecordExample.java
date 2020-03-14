import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;


public class DeleteRecordExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_weekend_batch1","root","admin");
			Statement st = con.createStatement();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter your Id for deletion");
			int id = Integer.parseInt(sc.nextLine());
			
			int rs= st.executeUpdate("DELETE FROM EMPLOYEE WHERE ID_EMP="+id);
			if(rs>0){
				System.out.println("Record = "+id+" is deleted successfully.");
			}else{
				System.out.println("Record deletation is failed.");
			}
			st.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
