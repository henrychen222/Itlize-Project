package com.easylearn.abstractpkg;

public class Anane extends Interview {

	@Override
	public void schduled() {
		System.out.println(" I have reached very late : around 01:00 PM");
	}
	
	@Override
	public double travelRembusment() {
		double myExpenses = 600.35;
		System.out.println("I am travling from NewJersy to Newyork");
		System.out.println("I have travled by  Bus");
		System.out.println("My total fare cost is "+myExpenses);
		return myExpenses;
	}
	
	public void wentMovie(){
		System.out.println("Watching Movie");
	}

}
