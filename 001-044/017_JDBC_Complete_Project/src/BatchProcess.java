// prg to read data from DB table
import java.sql.*;

public class BatchProcess {
	public static void main(String args[]) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_weekend_batch1", "root", "admin");
		con.setAutoCommit(false);

		Statement st = con.createStatement();

		st.addBatch("UPDATE EMPLOYEE set FIRST_NAME='Vijay' WHERE ID_EMP=2");
		st.addBatch("INSERT INTO EMPLOYEE (FIRST_NAME,LAST_NAME,MIDDLE_NAME,PHONE_NUMBER,EMAIL_ID,TX_ADDRESS) VALUES ('Declaro','Declaro','Declaro','8978964565','Declaro@yahoo.com','PO BOX 469,Atlanta,GA,USA')");
		st.addBatch("DELETE FROM EMPLOYEE WHERE ID_EMP=6");

		int result[] = st.executeBatch();
		System.out.println("NO.OF records that  are effected == " + result.length);

		// logic of Tx
		boolean rollBackFlag = false;

		for (int i = 0; i < result.length; ++i) {
			if (result[i] == 0) {
				rollBackFlag = true;
				break;
			}
		}

		if (!rollBackFlag) {
			con.commit();
			System.out.println("Tx is committed");
		} else {
			con.rollback();
			System.out.println("Tx is rolled back");
		}

		st.close();
		con.close();

	}// main
}// class

