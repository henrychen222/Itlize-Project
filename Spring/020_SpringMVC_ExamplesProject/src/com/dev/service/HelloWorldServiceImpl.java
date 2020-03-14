package com.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.dao.HelloWorldDAO;

@Service("HelloWorldService")
public class HelloWorldServiceImpl implements HelloWorldService {
	
@Autowired
HelloWorldDAO dao;

public HelloWorldServiceImpl(){
	System.out.println("Service Constructor called");
}
@Override
public String findHelloService() {
	 
	System.out.println("HelloWorldService class is called.!!!");
	String message = dao.getHelloDao();
	return message;
}

//DAO Methods

}
