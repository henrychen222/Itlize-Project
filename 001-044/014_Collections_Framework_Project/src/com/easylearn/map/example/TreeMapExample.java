package com.easylearn.map.example;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeMapExample {

	public static void main(String[] args) {
		
		TreeMap<String, Long> phoneBook = new TreeMap<>();
		
		phoneBook.put("Bob", new Long(879767453));
		phoneBook.put("Meghanath", new Long(879767454));
		phoneBook.put("Vicky", new Long(879767455));
		phoneBook.put("Tommy", new Long(879767456));
		phoneBook.put("Imitaz", new Long(879767457));
		phoneBook.put("Meghanath", new Long(879767458));
		phoneBook.put("Vishnavi", null);
		//phoneBook.put(true, "Srenivas");
		//phoneBook.put(null, new Long(879767459));

		
		System.out.println(phoneBook);
		
		System.out.println(phoneBook.get("Vicky"));
		
		System.out.println(phoneBook.keySet());
		
		System.out.println(phoneBook.values());
		
		
		System.out.println("******************************** For each loop **************************************");
		for (String key : phoneBook.keySet()) {
			System.out.println("Key="+key +"   \t value="+phoneBook.get(key));
		}
		
		System.out.println("******************************** Iterator **************************************");
		Iterator<String> itr=phoneBook.keySet().iterator();
		while(itr.hasNext()){
			Object key = itr.next();
			if("Hadoop".equals(key)){
				itr.remove();
				System.out.println("<<==============Hadoop is removed from the hash=====>>>");
			}
			System.out.println("Key="+key +"   \t value="+phoneBook.get(key));
		}
		
		System.out.println("******************************** EntrySet **************************************");
		Iterator<Entry<String, Long>> itr1=phoneBook.entrySet().iterator();
		while (itr1.hasNext()) {
			Entry<String, Long> entry = itr1.next();
			System.out.println("Key="+entry.getKey() +"   \t value="+entry.getValue());
		}
		
		
		System.out.println(phoneBook);
		System.out.println("HashSet size ="+phoneBook.size());
		System.out.println("HashSet is Empty="+phoneBook.isEmpty());


	}

}
