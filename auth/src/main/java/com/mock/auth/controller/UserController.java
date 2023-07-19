package com.mock.auth.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mock.auth.feignConfig.Consumer;
import com.mock.auth.model.User;

@RestController
@RequestMapping("/auth/user")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {
    
    @Autowired
    private Consumer consumer;
    
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
    	User newUser = consumer.registerUser(user);
		if (newUser == null) return new ResponseEntity<>("user already exists", HttpStatus.CONFLICT);
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/api")
	public ResponseEntity<List<User>> getAllUsers()
	{
		return new ResponseEntity<List<User>>(consumer.getAllUsers(), HttpStatus.OK);
	}
	
	@GetMapping("/api/{name}")
	public ResponseEntity<?> getUser(@PathVariable String name)
	{
		User user = consumer.getUserByName(name);
		if (user == null) {
			return new ResponseEntity<>("user not found", HttpStatus.NOT_FOUND);
		}else{
			return new ResponseEntity<>(consumer.getUserByName(name), HttpStatus.OK);	
	    }
	}

	@PutMapping("/api/{email}")
	public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String email){
		User upUser = consumer.updatUser(user, email);
		if (upUser == null){
			return new ResponseEntity<>("no user", HttpStatus.NOT_FOUND);
		}else{
			return new ResponseEntity<>(upUser, HttpStatus.OK);
		}
	}

	@DeleteMapping("/api/{email}")
	public ResponseEntity<?> deleteUser(@PathVariable String email){
		Boolean status = consumer.deleteUser(email);
		if (status){
			return new ResponseEntity<>("true", HttpStatus.OK);
		}else{
			return new ResponseEntity<>("false", HttpStatus.NOT_FOUND);
		}
	}
}
