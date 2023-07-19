package com.mock.userReg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mock.userReg.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

  @Query("Select u from User u where u.email=?1 and u.password=?2")
  public User validateUser(String email, String password);
  
  @Query("Select u from User u where u.username=?1")
	public User findByUserName(String username);
}
