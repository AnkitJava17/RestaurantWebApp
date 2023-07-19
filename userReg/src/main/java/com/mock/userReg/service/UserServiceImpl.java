package com.mock.userReg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.userReg.model.User;
import com.mock.userReg.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepo;

    @Override
    public User saveUser(User user) {
        Optional<User> userObj = userRepo.findById(user.getEmail());

        if (userObj.isPresent()){
            return null;
        }else{
            return userRepo.save(user);
        }
    }
    
    @Override
    public User getUserByUsername(String username) {
        User user = userRepo.findByUserName(username);
        if (user == null) return null;
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User validateUser(String email, String password) {
        return userRepo.validateUser(email, password);
    }

    @Override
    public User updateUser(User user, String email) {
        Optional<User> userObj = userRepo.findById(email);
        User newUser;
        if (userObj.isPresent()){
            newUser = userObj.get();
            newUser.setMobile(user.getMobile());
            newUser.setPassword(user.getPassword());
            newUser.setUsername(user.getUsername());
            return userRepo.save(newUser);
        }else{
            return null;
        }
    }

    @Override
    public boolean deleteUser(String email) {
        if (userRepo.findById(email) == null){
            return false;
        }else{
            userRepo.deleteById(email);
            return true;
        }
    }

    
}
