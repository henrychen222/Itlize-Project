package com.easylearn.list.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListTraversalExample {

	public static void main(String[] args) {

		ArrayList<Object> list = ArrayListExample.getArrayListData();
		
		System.out.println("******************************** for loop **************************************");
		
		for(int i=0; i< list.size(); i++){
			System.out.println(list.get(i));
		}
		
		System.out.println("******************************** For each loop (JDK 1.5)**************************************");
		for (Object element : list) {
			System.out.println(element);
		}
		
		System.out.println("******************************** Iterator **************************************");
		Iterator<Object> itr=list.iterator();
		while(itr.hasNext()){
			Object obj = itr.next();
			if(obj.equals("Hadoop")){
				itr.remove();
				System.out.println("<<==============Hadoop is removed from the list=====>>>");
				continue;
			}
			System.out.println(obj);

		}
		
		System.out.println("******************************** ListIterator **************************************");
		ListIterator<Object> lItr=list.listIterator(list.size());
		while(lItr.hasPrevious()){
			Object obj = lItr.previous();
			if(obj.equals("Hadoop")){
				lItr.remove();
				System.out.println("<<==============Hadoop is removed from the list=====>>>");
				lItr.add("Scala");
				continue;
			}
			System.out.println(obj);
		}
		
		System.out.println(list);
		System.out.println("ArrayList size ="+list.size());
		System.out.println("ArrayList is Empty="+list.isEmpty());
	}

}
