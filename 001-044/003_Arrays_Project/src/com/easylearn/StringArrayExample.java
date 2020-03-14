package com.easylearn;

public class StringArrayExample {

	public static void main(String[] args) {

		String str[] = new String[15];

		str[0] = "JAVA SE";
		str[1] = "JAVA EE";
		str[2] = "JAVA ME";
		str[3] = "Servlet";
		str[4] = "JSP";
		str[5] = "JDBC";
		str[6] = "Hibernate";
		str[7] = "Spring";
		str[8] = "Struts";
		str[9] = "EJB";
		str[10] = "Maven";

	
		String str1[] = str;
		str1[11] = "SQL";
		for (int i = 0; i < str1.length; i++) {
			System.out.println(" str1[" + i + "] Element is  = " + str1[i]);
		}
		
		for (int i = 0; i < str.length; i++) {
			System.out.println(" str[" + i + "] Element is  = " + str[i]);
		}
		

	}

}
