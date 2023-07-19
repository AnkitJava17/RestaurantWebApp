package com.mock.auth.feignConfig;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mock.auth.model.User;


@FeignClient(name="user-service", url = "http://localhost:8090/api/user")
public interface Consumer {
	
	@PostMapping
	public User registerUser(@RequestBody User user);
	
    @GetMapping
    public List<User> getAllUsers();

    @GetMapping("/{email}")
    public User getUserByName(@PathVariable String email);

    @PostMapping("/login")
    public User validate(@RequestBody User user);

    @PutMapping("/{email}")
    public User updatUser(@RequestBody User user, @PathVariable String email);

    @DeleteMapping("/{email}")
    public boolean deleteUser(@PathVariable String email);
}
