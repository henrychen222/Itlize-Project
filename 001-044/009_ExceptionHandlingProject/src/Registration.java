import java.util.Date;

public class Registration {

	public static void main(String[] args) {
		
		Registration reg =new Registration();
		try {
			reg.register(new Date(), null, null);
		} catch (VoterRegistrationFailedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void register(Date dob, String ssn, Integer ddl) throws VoterRegistrationFailedException {
		
		if((dob !=null && dob.getYear() >= 18) || (ssn != null  || ddl != null)){
			 throw new VoterRegistrationFailedException("Voter Registration Application is rejected.");
		}
		
		/* Business logic
		 * ...............
		 * ..............
		 * .............
		 *  
		 */
		
	}

}
