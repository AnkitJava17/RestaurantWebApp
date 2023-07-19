package com.mock.userReg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mock.userReg.model.User;
import com.mock.userReg.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public User registerUser(@RequestBody User user) {
		User newUser = userService.saveUser(user);
		return newUser;
	}
	
	 @GetMapping
		public List<User> getAllUsers(){
			List<User> usersList = userService.getAllUsers();
			return usersList;
	    }

	 @GetMapping("/{username}")
	 public User getUserByName(@PathVariable String username){
		 User user = userService.getUserByUsername(username);
		 return user;
	 }

	 @PostMapping("/login")
	 public User validate(@RequestBody User user){
		return userService.validateUser(user.getEmail(), user.getPassword());
	 }

	 @PutMapping("/{email}")
	 public User update(@RequestBody User user, @PathVariable String email){
		return userService.updateUser(user, email);
	 }

	 @DeleteMapping("/{email}")
	 public Boolean delete(@PathVariable String email){
		return userService.deleteUser(email);
	 }

}