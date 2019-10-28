package com.itlize.Korera.Service;

import java.util.List;

import com.itlize.Korera.Domain.User;

public interface UserService {

	
	public List<User> getAllUsers();
	
	public User getById(int id);
	
	public User authentication(String email, String password) throws Exception;
	
	public User signup(User u) throws Exception;
}
