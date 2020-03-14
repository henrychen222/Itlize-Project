package com.easylearn;

import java.util.Calendar;
import java.util.Date;

public class DemoBean implements DemoBeanInter {

	private String message;

	public void setMessage(String message) {
		System.out.println("Setter Injection is performed by IOC Container");
		this.message = message;
	}

	public DemoBean() {
		System.out.println("DemoBean object is constructed by BeanFactory");
	}

	public void getCurrentDateAndTime() {
		Date currDate = Calendar.getInstance().getTime();
		System.out.println("Current Date & Time :: " + currDate);
	}

	public String wish(String userName) {

		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		String wishMsg = null;

		if (hour < 12) {
			wishMsg = "Good Morning";
		} else if (hour >= 12 && hour <= 17) {
			wishMsg = "Good Afternoon";
		} else {
			wishMsg = "Good Evening";
		}

		return wishMsg + " :: " + userName + "  --> DI message ::-> " + message;
	}

}
