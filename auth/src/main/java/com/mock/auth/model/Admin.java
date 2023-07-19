package com.mock.auth.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mock.auth.feignConfig.Consumer;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Admin {
    
    @Autowired
    Consumer consumer;

    @OneToMany
    private List<User> user;

    void setUser(){
        this.user = consumer.getAllUsers();
    }
}
