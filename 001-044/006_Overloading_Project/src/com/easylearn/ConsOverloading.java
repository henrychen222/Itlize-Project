package com.easylearn;

public class ConsOverloading {
	
	int x;
	int y;
	int z;

	public ConsOverloading() {
		this(5);
		System.out.println("0-Args constructor is called..");
	}
	
	public ConsOverloading(int a) {
		this(10, 20);
		System.out.println("1-Arg constructor is called.."+a);
	}
	
	public ConsOverloading(int a, int b) {
		this(30, 40, 50);
		System.out.println("2-Args constructor is called.."+(a+b));
	}
	
	public ConsOverloading(int a, int b, int c) {
		System.out.println("3-Args constructor is called.."+(a+b+c));
	}

	public static void main(String[] args) {

		ConsOverloading obj=new ConsOverloading();

	}

}
