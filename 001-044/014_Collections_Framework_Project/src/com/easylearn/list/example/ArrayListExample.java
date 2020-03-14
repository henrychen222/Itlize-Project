package com.easylearn.list.example;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListExample {

	public static void main(String[] args) {
		getArrayListData();
	}

	public static ArrayList<Object> getArrayListData() {
		
		ArrayList<Object> list = new ArrayList<Object>(100); //10(X) + 20(10) + 30(10) + 10
		System.out.println("ArrayList size =" + list.size());
		System.out.println("ArrayList is Empty=" + list.isEmpty());

		//ArrayList - Synchronized
		Collections.synchronizedList(list);
		list.ensureCapacity(5); //10(X) + 15(5) + 20(5) + 25(5)
		
		list.add(101);
		list.add("John Smith");
		list.add(new Double(7500.56));
		list.add(true);
		list.add("PO BOX 897, George ST, Atlanta, GA");
		list.add("JAVA");

		list.add(102);
		list.add("Matt Burns");
		list.add(new Double(0.0));
		list.add(false);
		list.add("Flat 605, APT #8, Main ST, Atlanta, GA");
		list.add("Masters");

		list.add(6, "==NEW STUDENT===");
		list.set(5, "Hadoop");

		list.remove(new Double(0.0));

		System.out.println(list);

		System.out.println("ArrayList size =" + list.size());
		System.out.println("ArrayList is Empty=" + list.isEmpty());

		System.out.println("======Adding a new Collection========");
		ArrayList<String> studentList = new ArrayList<String>();
		studentList.add("Bob");
		studentList.add("Meghanath");
		studentList.add("Tommy");
		studentList.add("Initaz");
		studentList.add("Vicky");

		System.out.println(studentList);

		list.add(studentList);

		System.out.println(list);
		System.out.println("ArrayList size =" + list.size());
		System.out.println("ArrayList is Empty=" + list.isEmpty());

		list.addAll(studentList);

		System.out.println(list);

		System.out.println("Does Bob contain on the list ===> " + list.contains("Bob"));

		System.out.println("Get a specified index value ==>" + list.get(9));

		System.out.println("ArrayList size =" + list.size());
		System.out.println("ArrayList is Empty=" + list.isEmpty());

		// System.out.println(list.removeAll(list));

		return list;
	}

}
