package com.buddy.foodManagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.buddy.foodManagement.model.Food;

@Repository
public interface FoodMenuRepository extends MongoRepository<Food, String> {

}
