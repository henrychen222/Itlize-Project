package com.easylearn.list.example;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		
		ArrayList<Object> list =new ArrayList<Object>();  // type safety
		list.ensureCapacity(5);
		System.out.println("Size of list == "+list.size());
		System.out.println("IsEmpty of list == "+list.isEmpty());

		
		list.add(101);
		list.add("John Smith");
		list.add(8500.955);
		list.add(true);
		
		list.add(new Integer(102));
		list.add(new String("Matt Burns"));
		list.add(new Double(125000.500));
		list.add(new Boolean(false));
		
		list.add(new Integer(103));
		
		list.add(new Employee());
		list.addAll(list);

		list.add(list);
		
		list.add(4, "new Data");

		//list.set(4, "new Data");
		
		System.out.println(list);

		list.remove(4);
		System.out.println(list);

		System.out.println("'Matt Burns' is in list? == "+list.contains("Matt Burns"));

		System.out.println("Size of list == "+list.size());
		System.out.println("IsEmpty of list == "+list.isEmpty());
		
		Double db = (Double) list.get(6); //type casting
		System.out.println("Annaul salary == "+list.get(6));

		float monthSal = (float) (db/12);
		System.out.println("Monthly salary == "+monthSal);

		
		System.out.println(list);
		

	}

}

class Employee{
	
}
