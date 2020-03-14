package com.easylearn.abstractpkg;

public class WellsFaroAdmin {

	public static void main(String[] args) {

		Interview ref;
		double expToEmployee;

		System.out.println("====Tommy Rembusment====");
		ref = new Tommy();
		ref.schduled();
		expToEmployee = ref.travelRembusment();
		System.out.println("Total Refund Amout for Tommy =" + expToEmployee);
		
		System.out.println("====Anane Rembusment====");
		ref = new Anane();
		ref.schduled();
		expToEmployee = ref.travelRembusment();
		expToEmployee = 0;
		System.out.println("Total Refund Amout for Anane =" + expToEmployee);

	}

}
