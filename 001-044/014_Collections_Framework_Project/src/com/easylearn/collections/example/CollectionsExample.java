package com.easylearn.collections.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsExample {

	public static void main(String[] args) {
		
		List<Integer> list=new ArrayList<>();
		list.add(505);
		list.add(101);
		list.add(404);
		list.add(202);
		list.add(303);
		list.add(101);
		
		System.out.println(list);
		
		Collections.sort(list);
		System.out.println(list);
		
		Comparator<Integer> reverseOrder = Collections.reverseOrder();
		Collections.sort(list, reverseOrder);
		
		//Collections.reverse(list);

		System.out.println(list);
		
		
		List<String> strList=new ArrayList<>();
		strList.add("Bob");
		strList.add("Meghanath");
		strList.add("Vicky");
		strList.add("Tommy");
		strList.add("Imitaz");
		strList.add("Meghanath");
		
		System.out.println(strList);
		
		Collections.sort(strList);
		System.out.println(strList);
		
		Collections.reverse(strList);
		System.out.println(strList);


	}

}
