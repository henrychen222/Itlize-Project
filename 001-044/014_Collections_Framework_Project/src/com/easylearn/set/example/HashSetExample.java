package com.easylearn.set.example;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {

	public static void main(String[] args) {

		HashSet<Object> hash = new HashSet<Object>();  // Random --->> Hashing Algoritham 
		hash.add("J2SE");
		hash.add("J2EE");
		hash.add("Servlet");
		hash.add("JDBC");
		hash.add("JSP");
		hash.add("Hibernate");
		hash.add("Spring");
		hash.add("WebServices");
		hash.add("JDBC");
		hash.add("J2SE");
		hash.add(new Double(152.126));
		hash.add(true);
		hash.add(null);

		System.out.println(hash);
		
		System.out.println("******************************** For each loop **************************************");
		for (Object element : hash) {
			System.out.println(element);
		}
		
		System.out.println("******************************** Iterator **************************************");
		Iterator<Object> itr=hash.iterator();
		while(itr.hasNext()){
			Object obj = itr.next();
			if("Hibernate".equals(obj)){
				itr.remove();
				System.out.println("<<==============Hibernate is removed from the hash=====>>>");
			}
			System.out.println(obj);

		}
		
		System.out.println(hash);
		System.out.println("HashSet size ="+hash.size());
		System.out.println("HashSet is Empty="+hash.isEmpty());

		

	}

}
