package com.easylearn;

import java.util.StringTokenizer;

public class StringTokenizerExample {

	public static void main(String[] args) {

		System.out.println("=======Default Delimiter by SPACE ===========");
		String str = "Hi Goog Morning, how are you, I am doing good, How about you";
		StringTokenizer st = new StringTokenizer(str); // default delimiter is
														// "SPACE"
		while (st.hasMoreElements()) {
			System.out.println(st.nextElement());
		}

		System.out.println("=======Delimited by COMMA(,) ===========");
		st = new StringTokenizer(str, ",");
		while (st.hasMoreElements()) {
			System.out.println(st.nextElement());
		}

		System.out.println("=======Delimited by PIPE(|) ===========");
		str = "JOHN|SMITH|AARON|1234567890|9874652|USA";
		st = new StringTokenizer(str, "|");
		while (st.hasMoreElements()) {
			System.out.println(st.nextElement());
		}

		System.out.println("=======String.split() ===========");
		String data[] = str.split("\\|");
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}

	}

}
