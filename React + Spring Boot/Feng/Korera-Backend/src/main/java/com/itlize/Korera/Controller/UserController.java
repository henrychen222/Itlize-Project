package com.itlize.Korera.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itlize.Korera.Domain.User;
import com.itlize.Korera.Service.UserService;
import com.itlize.Korera.Util.JWTProvider;


@RestController
@CrossOrigin(origins="http://localhost:3000")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JWTProvider jwtProvider;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public User getById(@PathVariable("id")int id) {
		return userService.getById(id);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) throws Exception{
		String email = user.getEmail();
		User loginUser = null;
		try {
			loginUser = userService.authentication(email, user.getPassword());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}
		String token = jwtProvider.createToken(email, new ArrayList<String>());
        
        Map<Object, Object> model = new HashMap<>();
        model.put("username", loginUser.getUsername());
        model.put("token", token);
		return ResponseEntity.ok(model);
	}
	
	@PostMapping("/signup")
	public User signup(@RequestBody User user) throws Exception{
		try {
			return userService.signup(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}
}	
