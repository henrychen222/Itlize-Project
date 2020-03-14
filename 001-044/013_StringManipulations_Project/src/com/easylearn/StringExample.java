package com.easylearn;

public class StringExample {

	public static void main(String[] args) {
		// 1: SCP(String Constant Pool) memory allocation
		String str = "Glosing";
		String str2 = "James";
		String str3 = "Glosing";

		System.out.println(str.hashCode() + " " + str2.hashCode() + " " + str3.hashCode());

		// 2: Heap memory allocation
		String st = new String("glosing");
		String st2 = new String("James");
		String st3 = new String("Glosing");

		System.out.println(st.hashCode() + " " + st2.hashCode() + " " + st3.hashCode());
		
		System.out.println("comparing (str==st)  ==> " +(str==st)); // objects
		System.out.println("comparing (str.equals(st))  ==> " +(str.equals(st)));  //true or false
		System.out.println("comparing (str.equalsIgnoreCase(st))  ==> " +(str.equalsIgnoreCase(st)));
		System.out.println("comparing (str.compareTo(st))  ==> " +(str.compareTo(st)));  // +ve, 0, -ve
		System.out.println("comparing (str.compareToIgnoreCase(st))  ==> " +(str.compareToIgnoreCase(st)));  // +ve, 0, -ve
		
		System.out.println("substring in Str ==> "+str.substring(3));

		System.out.println("comparing (str==str3)  ==> " +(str==str3));
		
		System.out.println("comparing (str2==st2)  ==> " +(str2==st2));
		
		String str4 = "              Welcome to JAVA Programming                               ";
		System.out.println(str4.trim());
		System.out.println(str4.replaceAll("\\s+",""));
		
		/** String formatters **/
		String str5 = "%s  have '%f'$ in my pocket";
		System.out.println(String.format(str5,"Amol", 960.95));
		
		int i = 123405;
		System.out.println("My SSN ID =" + String.format("%09d", i));
		
		
		String str1 = "SummitWorks";
		System.out.println(str1 +" ===> "+str1.hashCode());
		str1 = "Oracle";
		System.out.println(str1 +" ===> "+str1.hashCode());
		str1.concat("Mircosoft");
		System.out.println(str1 +" ===> "+str1.hashCode());
		str1 = str1.concat("Mircosoft");
		System.out.println(str1 +" ===> "+str1.hashCode());


	}

}
