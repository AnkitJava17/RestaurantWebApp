package com.buddy.foodManagement.controller;

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

import com.buddy.foodManagement.model.Food;
import com.buddy.foodManagement.service.FoodMenuService;


@CrossOrigin(origins ="http://localhost:4200" )
@RestController
@RequestMapping("/api/foodMenu")
public class FoodMenuController {
	
	@Autowired
    private FoodMenuService foodMenuService;
	

    @GetMapping
    public ResponseEntity<List<Food>> getAllFood() {
        return new ResponseEntity<List<Food>>(foodMenuService.getAllFood(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Food> createFood(@RequestBody Food food) {
        return new ResponseEntity<Food>(foodMenuService.add(food), HttpStatus.CREATED);
    }

    @GetMapping("/{foodName}")
    public ResponseEntity<Food> getFoodById(@PathVariable String foodName) {
        return new ResponseEntity<Food>(foodMenuService.getFood(foodName),HttpStatus.OK);
    }

    @PutMapping("/{foodName}")
    public ResponseEntity<Food> updateFood(@PathVariable String foodName, @RequestBody Food updatedFood) {
        Food food = foodMenuService.update(updatedFood, foodName);
        return new ResponseEntity<Food>(food, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{foodName}")
    public ResponseEntity<String> deleteFood(@PathVariable String foodName) {
        boolean status = foodMenuService.delete(foodName);
        if (status == true){    
           return new ResponseEntity<String>("Deleted",HttpStatus.OK);
        }else{
           return new ResponseEntity<String>("Not Found",HttpStatus.CONFLICT);

        }
    }
 }
