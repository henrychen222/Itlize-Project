package com.easylearn;

public class StringBufferExample {

	public static void main(String[] args) {
		
		/** String Immutable class ***/
		String str = "Sreenivas";
		System.out.println(str.hashCode());
		
		str = "Alex";
		System.out.println(str.hashCode());

		str = str.concat(" Dhiksha");
		System.out.println(str.hashCode());

		System.out.println(str);  // 3 Objects will be initialzed
		
		/** StringBuffer mutable class ***/
		StringBuffer buffer=new StringBuffer();
		buffer.append("Sreenivas ");
		System.out.println(buffer.hashCode());

		buffer.append("Alex ");
		System.out.println(buffer.hashCode());

		buffer.append("Dhiksha ");
		System.out.println(buffer.hashCode());

		System.out.println(buffer);
		System.out.println(buffer.hashCode());
		
		

	}

}
