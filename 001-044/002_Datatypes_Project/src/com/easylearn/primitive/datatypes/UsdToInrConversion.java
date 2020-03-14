package com.easylearn.primitive.datatypes;

public class UsdToInrConversion {

	public static void main(String[] args) {

		int dollars = 900;
		float exchangeRate = 64.27f;
		double totalInrAmout = dollars * exchangeRate;
		
		int totalInr = (int) totalInrAmout;

		System.out.println("Total USD dollers =" + dollars);
		System.out.println("Today Exchange Rate =" + exchangeRate);
		System.out.println("Total USD to INR amout = " + totalInrAmout);
		System.out.println("Total USD to INR amout without decimals = " + totalInr);


	}

}
