package com.easylearn.abstractpkg;

public class Tommy extends Interview {

	@Override
	public double travelRembusment() {
		double myExpenses = 1500.35;
		System.out.println("I am travling from California to Newyork");
		System.out.println("I have travled from Air/Flight");
		System.out.println("I am total fare cost is "+myExpenses);
		return myExpenses;
	}
	
	public void shoping(){
		System.out.println("Buy a new laptop");
	}

}
