package com.easylearn.collections.example;

import java.util.Arrays;

public class ArraysExample {

	public static void main(String[] args) {

		int y[] = { 11, 13, 3, 5, 7, 9, 17, 19, 21 };

		for (int i = 0; i < y.length; i++) {
			System.out.println("Index of y[" + i + "] = " + y[i]);
		}

		System.out.println("============after sorting==============");
		Arrays.sort(y);
		for (int i = 0; i < y.length; i++) {
			System.out.println("Index of y[" + i + "] = " + y[i]);
		}

	}

}
