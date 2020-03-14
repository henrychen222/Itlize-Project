package com.easylearn;

// Custom Immutable class
public final class Employee {

	private final String socialSecurityNumber;

	public Employee(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber + "8956";
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	@Override
	public String toString() {
		return "Employee [socialSecurityNumber=" + socialSecurityNumber + "]";
	}

}
