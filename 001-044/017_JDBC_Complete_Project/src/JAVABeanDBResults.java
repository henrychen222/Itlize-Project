import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class JAVABeanDBResults {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<EmployeeBean> list=getDBResults();

		for (EmployeeBean emp : list) {
			System.out.println(emp.getId() + "\t" + emp.getLastname() + "\t"+ emp.getFirstname()+" \t"+emp.getPhonenumber()+"\t"+emp.getEmail());
		}

	}

	public static ArrayList<EmployeeBean> getDBResults() {
		ArrayList<EmployeeBean> list = new ArrayList<EmployeeBean>();
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_weekend_batch1","root", "admin");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM EMPLOYEE ");
			//ResultSetMetaData rsmd=rs.getMetaData();
			while (rs.next()) {
				EmployeeBean bean = new EmployeeBean();
				bean.setId(rs.getInt(1));
				bean.setFirstname(rs.getString(2));
				bean.setLastname(rs.getString(3));
				bean.setMiddlename(rs.getString(4));
				bean.setPhonenumber(rs.getString(5));
				bean.setEmail(rs.getString(6));
				bean.setAddress(rs.getString(7));
				list.add(bean);
			}
			rs.close();
			st.close();
			con.close();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
