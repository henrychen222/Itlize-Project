package com.easylearn;

public class Vachile {

	public String color;
	public int wheel;
	public String model;
	public int capacity;
	public double price;

	public Vachile(String color, int wheel, String model, int capacity, double price) {
		this.color = color;
		this.wheel = wheel;
		this.model = model;
		this.capacity = capacity;
		this.price = price;
	}

	public void displayDetails() {

		System.out.println("Color of the Vachile : " + color);
		System.out.println("wheel of the Vachile : " + wheel);
		System.out.println("model of the Vachile : " + model);
		System.out.println("capacity of the Vachile : " + capacity);
		System.out.println("price of the Vachile : " + price);

	}
	
}
