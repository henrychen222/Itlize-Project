package com.easylearn.list.example;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListExample {

	public static void main(String[] args) {
		
		LinkedList<Object> link=new LinkedList<>();
		link.add(101);
		link.add("John Smith");
		link.add(new Double(7500.56));
		link.add(true);
		link.add("PO BOX 897, George ST, Atlanta, GA");
		link.add("JAVA");
		
		link.remove(true);
		
		link.add(3, "SummitWorks");
		
		System.out.println(link);
		
		System.out.println("******************************** for loop **************************************");
		
		for(int i=0; i< link.size(); i++){
			System.out.println(link.get(i));
		}
		
		System.out.println("******************************** For each loop **************************************");
		for (Object element : link) {
			System.out.println(element);
		}
		
		System.out.println("******************************** Iterator **************************************");
		Iterator<Object> itr=link.iterator();
		while(itr.hasNext()){
			Object obj = itr.next();
			if(obj.equals("Hadoop")){
				itr.remove();
				System.out.println("<<==============Hadoop is removed from the link=====>>>");
			}
			System.out.println(obj);

		}
		
		System.out.println("******************************** ListIterator **************************************");
		ListIterator<Object> lItr=link.listIterator(link.size());
		while(lItr.hasPrevious()){
			System.out.println(lItr.previous());

		}
		
	}

}
