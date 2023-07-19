package com.mock.auth.feignConfig;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mock.auth.model.Food;

@FeignClient(name="food-service", url = "http://localhost:8082/api/foodMenu")
public interface FoodConsumer {
    
    @GetMapping
    public List<Food> getAllFood();

    @PostMapping
    public Food createFood(@RequestBody Food food);

    @GetMapping("/{foodName}")
    public Food getFoodById(@PathVariable String foodName);

    @PutMapping("/{foodName}")
    public Food updateFood(@PathVariable String foodName, @RequestBody Food updatedFood);

    @DeleteMapping("/{foodName}")
    public String deleteFood(@PathVariable String foodName);

}