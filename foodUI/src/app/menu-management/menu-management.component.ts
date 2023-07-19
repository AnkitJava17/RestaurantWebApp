import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FoodMenuServiceService } from '../services/food-menu-service.service';
import { FoodMenu } from './food-menu.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-menu-management',
  templateUrl: './menu-management.component.html',
  styleUrls: ['./menu-management.component.css'],
})
export class MenuManagementComponent implements OnInit {
  foodMenus: FoodMenu[];
  menuForm: FormGroup;
  foodMenu: FoodMenu = new FoodMenu();
  constructor(
    private http: HttpClient,
    private foodService: FoodMenuServiceService,
    private fb: FormBuilder
  ) {
    this.foodMenus = [];
    this.menuForm = this.fb.group({
      name: ['', Validators.required],
      description: ['', Validators.required],
    });
  }

  ngOnInit() {
    this.loadFoodMenus();
  }

  loadFoodMenus() {
    this.foodService.getAllFoodMenus().subscribe((data) => {
      this.foodMenus = data;
    });
  }

  createFoodMenu() {
    if (this.menuForm.valid) {
      this.foodMenu = this.menuForm.value;
      console.log(this.foodMenu);
      this.foodService.createFoodMenu(this.foodMenu).subscribe();
      // window.location.reload();
    }
  }

  deleteFoodMenu(foodMenu: any) {
    console.log(this.foodService.deleteFoodMenu(foodMenu.name).subscribe());
    window.location.reload();
  }

}
