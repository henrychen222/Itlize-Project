package com.easylearn.test;

import com.easylearn.WelcomeMessage;
import com.easylearn.WelcomeMessageService;

public class WelcomeMessageTestClient {

	public static void main(String[] args) {
		
		WelcomeMessageService service = new WelcomeMessageService();
		
		WelcomeMessage endpoint = service.getWelcomeMessagePort();
		
		String user = endpoint.wishUser("Paymon");
		
		System.out.println(user);

	}

}
