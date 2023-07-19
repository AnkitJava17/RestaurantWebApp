package com.mock.userReg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
public class UserRegApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(UserRegApplication.class, args);
	}

}
