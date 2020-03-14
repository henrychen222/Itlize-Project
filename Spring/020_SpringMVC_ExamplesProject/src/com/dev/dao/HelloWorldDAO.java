package com.dev.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public class HelloWorldDAO {
	
	public HelloWorldDAO(){
		System.out.println("dao constructor called");
	}
	
	public String getHelloDao(){
		System.out.println("HelloWorldDAO is called..");
		return "Spring Web MVC Project Flow Archtecture!!!!!!!!!!";
	}

}
