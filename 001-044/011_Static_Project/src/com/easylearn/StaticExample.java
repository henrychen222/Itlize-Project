package com.easylearn;

public class StaticExample {

	private static int x = 5;
	
	private static String str = "first";

	public static int add(int x, int y) {
		int c = x + y;
		return c;
	}

	public static void main(String[] args) {
		
		StaticExample.x = 100;
		
		System.out.println("x value = " + x);

		StaticExample.str = "second";
		
		System.out.println("str value =" + str);

		int result = StaticExample.add(15, 60);

		System.out.println("Result of X+Y = " + result);

	}

}
