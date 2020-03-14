package com.easylearn;

public class Bike extends Vachile 
{

	public Bike(String color, int wheel, String model, int capacity, double price) {
		super(color, wheel, model, capacity, price);
	}

	public static void main(String[] args) {
		
		System.out.println("=========First Bike ===============");
		Bike obj=new Bike("Black", 2, "Royal Enfiled", 2, 500.89);
		obj.displayDetails();
		
		System.out.println("=========Second Bike ===============");
		Bike obj2=new Bike("Purple", 3, "Bajaj Pulsar", 1, 425.60);
		obj2.displayDetails();

	}

}
