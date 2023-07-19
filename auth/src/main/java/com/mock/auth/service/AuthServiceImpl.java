package com.mock.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.auth.feignConfig.Consumer;
import com.mock.auth.model.User;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    Consumer consumer;

	@Override
	public boolean validateUserService(User user) {
		 User uObj = consumer.validate(user);
		 if (uObj == null) return false;
		 return true;
	}

}
