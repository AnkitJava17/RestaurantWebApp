import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FoodMenu } from '../menu-management/food-menu.model';
import { FoodMenuServiceService } from '../services/food-menu-service.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit{
  foodMenus: FoodMenu[];
  constructor(private http: HttpClient,
    private foodService: FoodMenuServiceService,
    ) { 
      this.foodMenus = [];
      }

  ngOnInit() {
    this.loadFoodMenus();
  }

  loadFoodMenus() {
    this.foodService.getAllFoodMenus().subscribe(
      data => {this.foodMenus = data}
    );
  }
}
