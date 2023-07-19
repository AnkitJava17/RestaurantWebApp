package com.mock.auth.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mock.auth.model.User;
import com.mock.auth.service.AuthService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.ServletException;

@RestController
@RequestMapping("/auth/user")
@CrossOrigin(origins = "http://localhost:4200/")
public class AuthController {

	@Autowired
	private AuthService authService;

	private Map<String, String> map = new HashMap<>();

	@PostMapping("/login")
	public ResponseEntity<?> doLogin(@RequestBody User user) {

		try {
			String jwtToken = generateToken(user);
			map.put("message", "User Successfully LoggedIn");
			map.put("token", jwtToken);

		} catch (Exception e) {
			map.put("message", e.getMessage());
			map.put("token", null);
			return new ResponseEntity<>(map, HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	public String generateToken(User user) throws ServletException {

		String jwtToken = "";

		if (user.getEmail() == null || user.getPassword() == null) {
			throw new ServletException("Please send valid email and password");
		}

		
		boolean flag = authService.validateUserService(user);
		if (!flag)
			throw new ServletException("Invalid Credentials");
		else {

			jwtToken = Jwts.builder().setSubject(user.getEmail()).setIssuedAt(new Date())
					.setExpiration(new Date(System.currentTimeMillis() + 3000000))
					.signWith(SignatureAlgorithm.HS256, "secret key").compact();
		}
		return jwtToken;
	}
}
