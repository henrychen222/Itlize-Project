package com.easylearn;

public class CommandLineArgsExample {

	public static void main(String[] args) {

		if (args.length <= 0) {
			System.out.println("Please proivde your command line arguments.....!!!!");
		}

		for (int i = 0; i < args.length; i++) {
			System.out.println("Your argument" + i + "   ---> " + args[i]);
		}

	}

}
