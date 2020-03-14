package com.easylearn;

public class Car extends Vachile {
	

	public Car(String color, int wheel, String model, int capacity, double price) {
		super(color, wheel, model, capacity, price);
	}
	
	public void extraDetails(){
		System.out.println("This is providing A/C");
		System.out.println("This is providing Audio/Vedio system");
		System.out.println("This is will go high speed");
	}

	public static void main(String[] args) {
		
		System.out.println("===========First Car====================");
		Car obj=new Car("White", 4, "Audi", 6, 8000.256);
		obj.displayDetails();
		obj.extraDetails();
		

		System.out.println("===========Second Car====================");
		Car obj1=new Car("Black", 4, "Range Rover", 5, 50000.56);
		obj.displayDetails();
		obj1.extraDetails();

	}

}
