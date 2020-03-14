package com.easylearn;

public class IntArrayExample {

	public static void main(String[] args) {
		
		System.out.println("******************** CASE - I *********************");
		/** Static Arrays ***/
		int x[] = new int[5];  
			x[0] = 1001;
			x[1] = 1002;
			x[2] = 1003;
			x[3] = 1004;
			x[4] = 1005;

		for (int i = 0; i < x.length; i++) {
			System.out.println(" x[" + i + "] Element is  = " + x[i]);
		}
		
		System.out.println("******************** CASE - II *********************");
		/** Dynamic Arrays **/
		int y[] = {2001, 2002, 2003, 2004, 2005, 2006}; 
		
		for (int i = 0; i < y.length; i++) {
			System.out.println(" y[" + i + "] Element is  = " + y[i]);
		}

		System.out.println("******************** CASE - III *********************");
		int z[] = new int[1000];
		
		for (int i = 0; i < z.length; i++) {
			z[i]  = i * 5;
		}
		
		for (int i = 0; i < z.length; i++) {
			System.out.println(" 5 * " + i + "  = " + z[i]);

		}

	}

}
