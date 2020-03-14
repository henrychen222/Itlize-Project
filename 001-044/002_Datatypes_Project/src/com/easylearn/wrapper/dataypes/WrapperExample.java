package com.easylearn.wrapper.dataypes;

public class WrapperExample {

	public static void main(String[] args) {

		Integer it = new Integer(15);
		Long lg = new Long(69852336);
		System.out.println("Integer value = " + it);
		System.out.println("Long value = " + lg);

		Float ft = new Float(150.65);
		Double de = new Double(562323.542);
		System.out.println("Float value = " + ft);
		System.out.println("Double value = " + de);

		Character cr = new Character('J');
		String str = new String("JAVA");
		System.out.println("Character value = " + cr);
		System.out.println("String value = " + str);

		Boolean bn = new Boolean(true);
		System.out.println("Boolean value = " + bn);
		
		
		System.out.println("type casted float value ="+ft.intValue());
		
		System.out.println("autoboxed long value = " + it.doubleValue());

	}

}
