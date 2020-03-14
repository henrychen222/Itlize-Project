package com.easylearn;

public class ConsExample {

	// Instance variables
	int x;
	int y;
	
	{
		System.out.println("instance block-1 is called..");
	}
	
	{
		System.out.println("instance block-2 is called..");
	}
	
	static{
		System.out.println("static block-1 is called..");
	}
	
	static{
		System.out.println("static block-2 is called..");
	}
	
	public ConsExample() {
		System.out.println("0-Args constructor is called.");
		x = 6;
		y = 7;
	}

	public ConsExample(int x, int y) { // local variables
		System.out.println("2-Args constructor is called.");
		this.x = x;
		this.y = y;
	}

	public void dispaly() {
		System.out.println("X value is =>" + x);
		System.out.println("Y value is =" + y);
	}

	public static void main(String[] args) { // 3 objects are initialized
		
		System.out.println("main method is started...!!!");
		
		ConsExample obj = new ConsExample();
		obj.dispaly();

		ConsExample obj1 = new ConsExample(15, 30);
		obj1.dispaly();

		ConsExample obj2 = new ConsExample(45, 65);
		obj2.dispaly();

		ConsExample obj3 = obj1;
		obj3.dispaly();

		System.out.println("Obj =" + obj.hashCode() + " \t Obj1 =" + obj1.hashCode() + " \t Obj2 =" + obj2.hashCode()
				+ " \t Obj3 =" + obj3.hashCode());

		System.out.println("main method is ended...!!!");

	}

}
