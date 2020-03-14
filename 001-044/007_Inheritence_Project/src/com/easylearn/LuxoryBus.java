package com.easylearn;

public class LuxoryBus extends Car {

	private String goods;

	public LuxoryBus(String color, int wheel, String model, int capacity, double price, String goods) {
		super(color, wheel, model, capacity, price);
		this.goods = goods;
	}
	
	@Override
	public void displayDetails() {
		System.out.println("Color of the LuxoryBus : " + color);
		System.out.println("wheel of the LuxoryBus : " + wheel);
		System.out.println("model of the LuxoryBus : " + model);
		System.out.println("capacity of the LuxoryBus : " + capacity);
		System.out.println("price of the LuxoryBus : " + price);
	}

	public void busDetails() {
		displayDetails();
		extraDetails();
		System.out.println("Goods is "+goods);
	}

	public static void main(String[] args) {

		System.out.println("===========First LuxoryBus====================");
		LuxoryBus obj = new LuxoryBus("Gray", 8, "Volvo", 40, 90000.23, " Apple Baskets");
		obj.busDetails();
		
		System.out.println("===========Second LuxoryBus====================");
		LuxoryBus obj1 = new LuxoryBus("Gray", 8, "Volvo", 40, 90000.23, " Mango Baskets");
		obj1.busDetails();

	}

}
