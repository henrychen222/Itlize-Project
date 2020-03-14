import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExceptionTestExample {

	public static void main(String[] args) {
		ExceptionTestExample example = new ExceptionTestExample();
		try {

			Thread.sleep(5000);

			example.displayDetails("admin", null);
		} catch (LoginFaliedException | InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void displayDetails(String username, String password) throws LoginFaliedException {
		System.out.println("Add =" + (5 + 6));
		System.out.println("Div =" + (5 / 6));

		if (username == null || password == null) {
			throw new LoginFaliedException();
		}

		// Database connection
		Connection con = null;
		try {

			try {
				con = DriverManager.getConnection("http://abc", username, password);
			} catch (SQLException e) {
				e.printStackTrace();
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Always Finally block will be executed");
		}

		System.out.println("Sub =" + (5 - 6));
		System.out.println("Mul =" + (5 * 6));

	}

}
