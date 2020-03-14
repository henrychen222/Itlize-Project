package com.easylearn;

public class MultiConsExample {
	
	int x;
	int y;
	int z;

	public MultiConsExample() {
		this(5);
		System.out.println("0-Args constructor is called..");
	}
	
	public MultiConsExample(int a) {
		this(10, 20);
		System.out.println("1-Arg constructor is called.."+a);
	}
	
	public MultiConsExample(int a, int b) {
		this(30, 40, 50);
		System.out.println("2-Args constructor is called.."+(a+b));
	}
	
	public MultiConsExample(int a, int b, int c) {
		a = (b+c) * 5;
		System.out.println("3-Args constructor is called.."+(a+b+c));
	}

	public static void main(String[] args) {

		MultiConsExample obj=new MultiConsExample();
		System.out.println(obj);

	}

}
