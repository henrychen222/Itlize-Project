 import java.sql.*;
import java.io.*;
 public class PhotoRetrive
 {
     public static void main(String args[])throws Exception
     {
 		Class.forName("com.mysql.jdbc.Driver");
 		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_weekend_batch1", "root", "admin");

       Statement st=con.createStatement();
       ResultSet rs=st.executeQuery("SELECT * FROM EMP_IMAGES");
       FileOutputStream fos = null;
       while(rs.next())
       {
         InputStream in=rs.getBinaryStream("EM_IMAGE");

         File file=new File("F:/workspace/db_data");
         file.mkdirs();
         fos=new FileOutputStream(file.getAbsoluteFile()+"/2_"+rs.getInt("ID_EMP")+"_"+rs.getString("NM_EMP")+".gif");
	     int bytesRead=0;
  	     byte [] buffer=new byte[4096];

    	 while((bytesRead=in.read(buffer))!=-1)
	     {
	        fos.write(buffer,0,bytesRead);
         }

		System.out.println("photo is stored in :: "+file.getAbsolutePath());

          fos.close();
	      in.close();
	      
	   }//if
       
       	  rs.close();
	      st.close();
	      con.close();
	      
       }//main
     }//class