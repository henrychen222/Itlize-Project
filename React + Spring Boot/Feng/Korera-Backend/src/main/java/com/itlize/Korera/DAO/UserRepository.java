package com.itlize.Korera.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itlize.Korera.Domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	public User findById(int id);
	
	public User findByEmail(String email);
}
