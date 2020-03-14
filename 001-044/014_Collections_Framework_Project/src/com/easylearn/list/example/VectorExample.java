package com.easylearn.list.example;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

public class VectorExample {

	public static void main(String[] args) {

		// Vector - Synchronized
		Vector<Object> vector = new Vector<Object>(5, 4);

		vector.add(101);
		vector.add("John Smith");
		vector.add(new Double(7500.56));
		vector.add(true);
		vector.add("PO BOX 897, George ST, Atlanta, GA");
		vector.add("JAVA");

		vector.addElement(101);
		vector.addElement("John Smith");

		System.out.println(vector);

		System.out.println("First Element =" + vector.firstElement());
		System.out.println("Last Element =" + vector.lastElement());

		System.out.println("******************************** Enumeration**************************************");

		Enumeration<Object> enumList = vector.elements();
		while (enumList.hasMoreElements()) {
			Object object = (Object) enumList.nextElement();
			System.out.println(object);
		}

		System.out.println("******************************** for loop **************************************");

		for (int i = 0; i < vector.size(); i++) {
			System.out.println(vector.get(i));
		}

		System.out.println("******************************** For each loop **************************************");
		for (Object element : vector) {
			System.out.println(element);
		}

		System.out.println("******************************** Iterator **************************************");
		Iterator<Object> itr = vector.iterator();
		while (itr.hasNext()) {
			Object obj = itr.next();
			if (obj.equals("Hadoop")) {
				itr.remove();
				System.out.println("<<==============Hadoop is removed from the vector=====>>>");
			}
			System.out.println(obj);

		}

		System.out.println("******************************** ListIterator **************************************");
		ListIterator<Object> lItr = vector.listIterator(vector.size());
		while (lItr.hasPrevious()) {
			System.out.println(lItr.previous());

		}

	}

}
