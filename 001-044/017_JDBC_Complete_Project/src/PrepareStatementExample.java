import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;



public class PrepareStatementExample {

	public static void main(String[] args) {
		try {
			int id=0;
			String firstName,lastName,middleName,phoneNumber,emailid,address;
			Scanner sc = new Scanner(System.in);
			
			//System.out.println("Please enter your Id");
			//id = Integer.parseInt(sc.nextLine());
			
			System.out.println("Please enter first Name");
			firstName = sc.nextLine();
			
			System.out.println("Please enter last Name");
			lastName = sc.nextLine();
			
			System.out.println("Please enter middle Name");
			middleName = sc.nextLine();
			
			System.out.println("Please enter Phone Number");
			phoneNumber = sc.nextLine();
			
			System.out.println("Please enter Email-Id");
			emailid = sc.nextLine();
			
			System.out.println("Please enter Address");
			address = sc.nextLine();
			
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_weekend_batch1","root","admin");
			
			Statement st= con.createStatement();
			ResultSet rs =  st.executeQuery("SELECT IFNULL(MAX(ID_EMP),0)+1 FROM EMPLOYEE");
			if(rs.next())
				 id = rs.getInt(1);
			
			String formattedId = String.format("%08d", id);
			
			PreparedStatement pst=con.prepareStatement("INSERT INTO EMPLOYEE (ID_EMP,FIRST_NAME,LAST_NAME,MIDDLE_NAME,PHONE_NUMBER,EMAIL_ID,TX_ADDRESS) " +
					"VALUES (?,?,?,?,?,?,?)");
			int i=1;
			pst.setString(i++, formattedId); // 00000001
			pst.setString(i++, firstName);
			pst.setString(i++, lastName);
			pst.setString(i++, middleName);
			pst.setString(i++, phoneNumber);
			pst.setString(i++, emailid);
			pst.setString(i++, address);

			int rs1= pst.executeUpdate();
			if(rs1 > 0){
				System.out.println(formattedId + " Record is inserted successfully."+rs1);
			}else{
				System.out.println("Record is inseration is failed.");
			}
			pst.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
