package com.mock.userReg.service;

import java.util.List;

// import org.springframework.stereotype.Service;

// import com.mock.userReg.exception.UserAlreadyExistsException;
// import com.mock.userReg.exception.UserNotFoundException;
import com.mock.userReg.model.User;

public interface UserService {

	public User validateUser(String email, String password);
	
	public User saveUser(User user);

	User getUserByUsername(String email);

	List<User> getAllUsers();

	User updateUser(User user, String email);

	boolean deleteUser(String email);
	
}
