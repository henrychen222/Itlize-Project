package com.easylearn;


class CalculatorExample {
	
	/**
	 * This method is used to perform Addition of two variables
	 * @param x - First Param for basic salary
	 * @param y - Second Param for HRA 
	 */
	public void sum(int x, int y){
		System.out.println("Add of "+(x+y));
	}

	
	/**
	 * This is a calculator method to perform the calculations.......... of two variables......
	 * @param x
	 * @param y
	 */
	public void calculator(int x, int y) {
		System.out.println("Addition of ( " + x + " + " + y + ") ==>" + (x + y));
		System.out.println("Substraction of (X-Y) =" + (x - y));
		System.out.println("Multiplication of (X*Y) ==>" + (x * y));
		System.out.println("Division of (X/Y) => " + (x / y));
		System.out.println();
	}	

}


public class MethodExample {
		
	public static void main(String[] args) {
		CalculatorExample obj = new CalculatorExample();
		obj.calculator(100, 50);
		obj.calculator(1500, 700);
		obj.calculator(2200, 900);
		//obj.calculator(2200.25, 900.65);

		obj.sum(100, 50);

	}

}
