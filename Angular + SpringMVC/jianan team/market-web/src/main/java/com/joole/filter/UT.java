package com.joole.filter;

import com.joole.domain.User;

public class UT {
	private User user;
	private String token;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public UT(User user, String token) {
		super();
		this.user = user;
		this.token = token;
	}
	
	

}
