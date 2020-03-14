package com.easylearn;

public class PerformenceTest {

	public static void main(String[] args) {

		System.out.println("======StringBuffer is Syncronized===============");
		Long startTime = System.currentTimeMillis();
		StringBuffer buffer = new StringBuffer("Welcome");
		for (int i = 0; i < 500000; i++) {
			buffer.append(" To Java Programming "+i);
		}
		Long endTime = System.currentTimeMillis();
		System.out.println("***** Total Time taken for StringBuffer ==" + (endTime - startTime));
		
		System.out.println("======StringBuilder is NOT Syncronized===============");
		Long startTime1 = System.currentTimeMillis();
		StringBuilder builder = new StringBuilder("Welcome");
		for (int i = 0; i < 500000; i++) {
			builder.append(" To Java Programming "+i);
		}
		Long endTime1 = System.currentTimeMillis();
		System.out.println("***** Total Time taken for StringBuilder ==" + (endTime1 - startTime1));

	}

}
