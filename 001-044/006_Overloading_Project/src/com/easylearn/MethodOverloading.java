package com.easylearn;

public class MethodOverloading {

	public MethodOverloading() {
		// TODO Auto-generated constructor stub
	}

	public void login(int dl, String password) {
		// validating the valid Driving License -- DDS
		System.out.println("your loggined successfully with your DL#"+dl);
	}
	
	public void login(String password, int dl) {
		// validating the valid Driving License -- DDS
		System.out.println("your loggined successfully with your DL#"+dl);
	}
	
	private void login(Long SSN, String password) {
		// Validating is valid SSN --- DAM
		System.out.println("your loggined successfully with your SSN#"+SSN);
	}

	protected void login(String emailId, String password) {
		// database check the emailId
		System.out.println("your loggined successfully with your emailId#"+emailId);

	}

	int login(int tokenId) {
		// Admistrator of the application
		System.out.println("Your Administrator, so your directly loggied in with tokenId#"+tokenId);
		return tokenId;
	}

	public static void main(String[] args) {
		
		MethodOverloading obj=new MethodOverloading();
		obj.login("sreenivas@gmail.com", "system123#");
		obj.login(123456789, "ssn123#");
		obj.login(526314, "dl123#");
		obj.login(4568);

	}

}
