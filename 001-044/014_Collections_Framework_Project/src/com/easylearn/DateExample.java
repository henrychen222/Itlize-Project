package com.easylearn;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateExample {

	public static void main(String[] args) {

		Date dt = new Date();
		System.out.println("Date=" + dt);

		SimpleDateFormat sdf = new SimpleDateFormat("MMM/dd/yyyy hh:mm:ss a zzzz");
		System.out.println("Formatted Date =" + sdf.format(dt));

		sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2018);
		cal.set(Calendar.DATE, 15);
		System.out.println("Calendar=" + cal.getTime());
		System.out.println("Formatted Calendar =" + sdf.format(cal.getTime()));

	}

}
