package com.buddy.foodManagement.service;

import java.util.List;

import com.buddy.foodManagement.model.Food;

//@Service
public interface FoodMenuService {
    public List<Food> getAllFood();
    
	public Food getFood(String name);

	public Food add(Food food);

	public Food update(Food updatedFood, String name);

	public boolean delete(String name);
    
    
}
