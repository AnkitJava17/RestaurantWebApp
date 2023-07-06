package com.buddy.foodManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buddy.foodManagement.model.Food;
import com.buddy.foodManagement.repository.FoodMenuRepository;

@Service
public class FoodMenuServiceImpl implements FoodMenuService {
	@Autowired
    private FoodMenuRepository foodMenuRepository;

    @Override
    public List<Food> getAllFood() {
    	return this.foodMenuRepository.findAll();
    }

	@Override
	public Food getFood(String food) {
        Optional<Food> newFood= foodMenuRepository.findById(food);

		if (newFood.isPresent()){
			return newFood.get();
		}else{
			return null;
		}
	}
	@Override
	public Food add(Food food) {
        return foodMenuRepository.save(food);
	}

	@Override
	public Food update(Food updatedFood, String name) {
		Food existingFoodMenu = foodMenuRepository.findById(name).orElse(null);
        if (existingFoodMenu != null) {
            existingFoodMenu.setName(updatedFood.getName());
            existingFoodMenu.setDescription(updatedFood.getDescription());
            return foodMenuRepository.save(existingFoodMenu);
        }
        return null;
	}

	@Override
	public boolean delete(String name) {
		if (foodMenuRepository.findById(name) != null){
       		foodMenuRepository.deleteById(name);
			return true;
		}else
			return false;
	}
}
