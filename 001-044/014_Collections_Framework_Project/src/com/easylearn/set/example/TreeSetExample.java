package com.easylearn.set.example;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {

		TreeSet<String> tree = new TreeSet<String>();  // Ascending Order --->> Hashing Algoritham 
		tree.add("J2SE");
		tree.add("J2EE");
		tree.add("Servlet");
		tree.add("JDBC");
		tree.add("JSP");
		tree.add("Hibernate");
		tree.add("Spring");
		tree.add("WebServices");
		tree.add("JDBC");
		tree.add("J2SE");
		//tree.add(null);
		/*tree.add(new Double(152.126));
		tree.add(true);*/
		
		System.out.println(tree);
		
		System.out.println("******************************** For each loop **************************************");
		for (Object element : tree) {
			System.out.println(element);
		}
		
		System.out.println("******************************** Iterator **************************************");
		Iterator<String> itr=tree.iterator();
		while(itr.hasNext()){
			Object obj = itr.next();
			if(obj.equals("Hibernate")){
				itr.remove();
				System.out.println("<<==============Hibernate is removed from the hash=====>>>");
				
				//tree.add("JPA");  java.util.ConcurrentModificationException
			}
			System.out.println(obj);

		}
		
		NavigableSet<String> descTreeSet = tree.descendingSet(); 
		System.out.println("******************************** For each loop ****** DESC********************************");
		for (String element : descTreeSet) {
			System.out.println(element);
		}
		
		System.out.println(tree);
		System.out.println("HashSet size ="+tree.size());
		System.out.println("HashSet is Empty="+tree.isEmpty());

		

	}

}
