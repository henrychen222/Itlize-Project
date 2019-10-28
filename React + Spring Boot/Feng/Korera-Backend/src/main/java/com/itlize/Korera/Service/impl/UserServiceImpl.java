package com.itlize.Korera.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itlize.Korera.DAO.UserRepository;
import com.itlize.Korera.Domain.User;
import com.itlize.Korera.Exception.AuthenticationException;
import com.itlize.Korera.Exception.UserExistsException;
import com.itlize.Korera.Service.UserService;

@Service
@Transactional 
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	
	@Override
	public User getById(int id) { 
		return userRepository.findById(id);
	}

	@Override
	public User authentication(String email, String password) throws Exception{
		// TODO Auto-generated method stub
		User loginUser = userRepository.findByEmail(email);
		if(loginUser == null || !loginUser.getPassword().equals(password)) throw new AuthenticationException();
		return loginUser;
	}

	@Override
	public User signup(User u) throws Exception{
		// TODO Auto-generated method stub
		if(userRepository.findByEmail(u.getEmail()) != null) throw new UserExistsException();
		userRepository.save(u);
		return u;
	}

}
