package com.easylearn;

public class Address {

	private Long strNo;
	private String addrLine1;
	private String city;
	private Long zipCode;
	private String state;
	private String country;

	public Address(Long strNo, String addrLine1, String city, Long zipCode, String state, String country) {
		System.out.println("Address : Constructor injection is performed......");
		this.strNo = strNo;
		this.addrLine1 = addrLine1;
		this.city = city;
		this.zipCode = zipCode;
		this.state = state;
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [strNo=" + strNo + ", addrLine1=" + addrLine1 + ", city=" + city + ", zipCode=" + zipCode
				+ ", state=" + state + ", country=" + country + "]";
	}

}
