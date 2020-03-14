package com.easylearn.list.example;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample1 {

	public static void main(String[] args) {
		
		System.out.println("=======CASE : 2=========");
		ArrayList<Integer> arrList= new ArrayList<Integer>(){{
			add(101);
			add(202);
			add(303);
		}};
		
		arrList.add(404);
		System.out.println(arrList);
		
		System.out.println("=======CASE : 3=========");
		List<Double> arrayList = new ArrayList<>();  // JDK 1.8
		arrayList.add(101.11);
		arrayList.add(202.22);
		arrayList.add(303.33);
		
		System.out.println(arrayList);

	}

}
