package com.mock.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mock.auth.feignConfig.FoodConsumer;
import com.mock.auth.model.Food;

@RestController
@RequestMapping("/auth/food")
@CrossOrigin(origins = "http://localhost:4200/")
public class FoodMenuController {

    @Autowired
    private FoodConsumer consumer;

    @GetMapping
    public ResponseEntity<List<Food>> getAllFood() {
        return new ResponseEntity<List<Food>>(consumer.getAllFood(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Food> createFood(@RequestBody Food food) {
        return new ResponseEntity<Food>(consumer.createFood(food), HttpStatus.CREATED);
    }

    @GetMapping("/{foodName}")
    public ResponseEntity<Food> getFoodById(@PathVariable String foodName) {
        return new ResponseEntity<Food>(consumer.getFoodById(foodName), HttpStatus.OK);
    }

    @PutMapping("/{foodName}")
    public ResponseEntity<Food> updateFood(@PathVariable String foodName, @RequestBody Food updatedFood) {
        return new ResponseEntity<Food>(consumer.updateFood(foodName, updatedFood), HttpStatus.OK);
    }

    @DeleteMapping("/{foodName}")
    public ResponseEntity<String> deleteFood(@PathVariable String foodName) {
        return new ResponseEntity<String>(consumer.deleteFood(foodName), HttpStatus.OK);
    }
}
