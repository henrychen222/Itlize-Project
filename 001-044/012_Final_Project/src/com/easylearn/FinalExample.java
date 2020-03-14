package com.easylearn;


 class SampleExample{
	
	public final void add(){
		System.out.println("addtion is performed.");
	}
}

public class FinalExample extends SampleExample {
	
	private static final int kg=1000; //grams
	private static final double pie = 3.14; // 22/7

	public static void main(String[] args) {
		// kg = 1500; 
		// pie = 9.15;
		System.out.println(kg);
		System.out.println(pie);
		
		FinalExample fe=new FinalExample();
		fe.add();
		fe.add1();

	}
	
	//@Override
	public void add1() {
		int x = 5;
		int y = 6;
		System.out.println("addtion of (x+y)" + (x + y));
	}
	

}
