package com.easylearn.interfacepkg;

public class InterfaceExample implements Third {

	@Override
	public void red() {
		System.out.println(" red() is called...");
	}

	@Override
	public void orange(String firstName, String lastName) {
		System.out.println(" orange(firstName=" + firstName + ", lastName=" + lastName + ") is called...");
	}

	@Override
	public void blue(int x, int y) {
		System.out.println(" blue(x=" + x + ", y=" + y + ") is called...");
	}

	@Override
	public void yellow() {
		System.out.println(" yellow() is called...");
	}

	private void test() {
		System.out.println("This is my own private method...!!!");
	}

	public static void main(String[] args) {

		System.out.println("=======InterfaceExample obj =================");
		InterfaceExample obj = new InterfaceExample();
		obj.red();
		obj.yellow();
		obj.blue(5, 6);
		obj.orange("James", "Gosling");
		obj.test();

		System.out.println("=======First f =================");
		First f = new InterfaceExample();
		f.red();
		// f.yellow();
		f.blue(5, 6);
		// f.orange("James", "Gosling");
		// f.test();

		System.out.println("=======Second s =================");
		Second s = obj;
		s.red();
		// s.yellow();
		// s.blue(5, 6);
		s.orange("James", "Gosling");
		// s.test();

		System.out.println("=======Third t=================");
		Third t;
		t = new InterfaceExample();
		t.red();
		t.yellow();
		t.blue(5, 6);
		t.orange("James", "Gosling");
		// t.test();

	}

}
