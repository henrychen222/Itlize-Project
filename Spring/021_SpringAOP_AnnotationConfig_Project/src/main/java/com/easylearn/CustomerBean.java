package com.easylearn;

import org.springframework.stereotype.Component;

@Component("customer")
public class CustomerBean {

	protected void browseEmployee(String customerName) {
		try {
			System.out.println(customerName + " Started: Browsing the Internet ");
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected void browseEmployee() {
		try {
			System.out.println(" Started: Browsing the Internet ");
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected void browseStudent() {
		try {
			System.out.println("@@@@@@@@@ Student Started: Browsing the Internet @@@@@@@@@");
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
