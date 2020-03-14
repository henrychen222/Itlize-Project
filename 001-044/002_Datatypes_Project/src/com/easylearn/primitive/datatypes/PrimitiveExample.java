/**
 * 
 */
package com.easylearn.primitive.datatypes;

/**
 * @author SreenivasReddy
 *
 */
public class PrimitiveExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int it = 15;
		long lg = 69852336;
		System.out.println("int value = " + it);
		System.out.println("long value = " + lg);

		float ft = 150.65f;
		double de = 562323.542;
		System.out.println("float value = " + ft);
		System.out.println("double value = " + de);

		char cr = 'J';
		String str = "JAVA";
		System.out.println("char value = " + cr);
		System.out.println("String value = " + str);

		boolean bn = true;
		System.out.println("boolean value = " + bn);
		
		it = (int) ft;  // Type Casting - value loss
		System.out.println("type casted float value ="+it);
		
		lg = it;  // Auto boxing 
		System.out.println("autoboxed long value = " + lg);

		

	}

}
