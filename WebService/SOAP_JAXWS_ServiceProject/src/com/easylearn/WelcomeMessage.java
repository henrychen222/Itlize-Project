package com.easylearn;

import java.util.Calendar;

import javax.jws.WebService;


@WebService
public class WelcomeMessage {

	public String wishUser(String userName) {
		String message;
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

		if (hour < 12) {
			message = "Good Morning";
		} else if (hour >= 12 && hour <= 17) {
			message = "Good Afternoon";
		} else {
			message = "Good Evening";
		}

		return message + " :: " + userName;
	}

}
