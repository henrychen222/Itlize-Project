package com.joole.dao;


import com.joole.domain.User;

public interface UserDAO {
	
	// user login
	public User getUser(int id);
	
	public User getUserbyName(String userName);
	
	public User getUserbyEmail(String userEmail);

	public void addUser(User user);
}
