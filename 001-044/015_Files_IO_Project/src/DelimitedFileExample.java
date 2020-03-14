import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DelimitedFileExample {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException, ParseException {
		
		   List<Employee> pojoList = new ArrayList<Employee>();
		   FileReader fr= new FileReader("F:/workspace/filefolder/DelimitedDataFile.txt");
		   BufferedReader br = new BufferedReader(fr);
		   String line = "";
		   int count=0;
		   while((line = br.readLine()) != null) {  
		       if(count != 0){
			       try {
					String[] fields = line.split("\\|");
					   Employee emp = new Employee();
					   emp.setFirstName(fields[0]);
					   emp.setLastName(fields[1]);
					   emp.setEmpId(Integer.valueOf(fields[2]));
					   emp.setSsnId(Integer.valueOf(fields[3]));
					   emp.setDlId(Integer.valueOf(fields[4]));
					   emp.setDob(parseDate(fields[5]));
					   emp.setAddress(fields[6]);
					   pojoList.add(emp);
				} catch (Exception e) {
					e.printStackTrace();
				}
		       }
			   count++;
		   }
		   
	    for (Employee em : pojoList) {
			System.out.println(em);
		}
		   fr.close();
		   br.close();

	}
	
	 private static Date parseDate(String dob) throws ParseException{
		  SimpleDateFormat sdf1= new SimpleDateFormat("dd-MM-yyyy");
		  return sdf1.parse(dob);
	  }

}
