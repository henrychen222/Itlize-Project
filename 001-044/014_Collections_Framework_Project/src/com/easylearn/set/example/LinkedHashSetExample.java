package com.easylearn.set.example;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetExample {

	public static void main(String[] args) {

		LinkedHashSet<Object> linkedHash = new LinkedHashSet<Object>();  // Insertion Order --->> Hashing Algorithm 
		
		Collections.synchronizedSet(linkedHash);
		
		linkedHash.add("J2SE");
		linkedHash.add("J2EE");
		linkedHash.add("Servlet");
		linkedHash.add("JDBC");
		linkedHash.add("JSP");
		linkedHash.add("Hibernate");
		linkedHash.add("Spring");
		linkedHash.add("WebServices");
		linkedHash.add("JDBC");
		linkedHash.add("J2SE");
		linkedHash.add(new Double(152.126));
		linkedHash.add(true);
		linkedHash.add(null);

		System.out.println(linkedHash);
		
		System.out.println("******************************** For each loop **************************************");
		for (Object element : linkedHash) {
			System.out.println(element);
		}
		
		System.out.println("******************************** Iterator **************************************");
		Iterator<Object> itr=linkedHash.iterator();
		while(itr.hasNext()){
			Object obj = itr.next();
			if("Hadoop".equals(obj)){
				itr.remove();
				linkedHash.add("test");
				System.out.println("<<==============Hadoop is removed from the hash=====>>>");
			}
			System.out.println(obj);

		}
		
		System.out.println(linkedHash);
		System.out.println("HashSet size ="+linkedHash.size());
		System.out.println("HashSet is Empty="+linkedHash.isEmpty());

		

	}

}
