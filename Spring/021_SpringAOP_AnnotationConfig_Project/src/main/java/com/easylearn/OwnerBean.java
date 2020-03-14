package com.easylearn;

import org.springframework.stereotype.Component;

@Component("owner")
public class OwnerBean {

	public String browseOwner(String customerName) {
		try {
			System.out.println(customerName + " Started: Browsing the Internet by Owner");
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return customerName;
	}

}
