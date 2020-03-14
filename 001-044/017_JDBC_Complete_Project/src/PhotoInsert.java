import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class PhotoInsert {
	public static void main(String args[]) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_weekend_batch1", "root", "admin");

		PreparedStatement ps = con.prepareStatement("insert into EMP_IMAGES (NM_EMP,EM_SALARY,EM_IMAGE) values (?,?,?)");
		ps.setString(1, "donald trump");
		ps.setFloat(2, 15000000);

		File f = new File("F:/workspace/filefolder/images/donald-trump.jpg");
		FileInputStream fis = new FileInputStream(f);
		
		ps.setBinaryStream(3, fis, (int) f.length());

		ps.executeUpdate();

		fis.close();
		ps.close();
		con.close();
		System.out.println("Document is Inserted successfully......!!!!!");
	}// main
}// class