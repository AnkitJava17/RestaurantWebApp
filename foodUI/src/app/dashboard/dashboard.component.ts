import { Component, OnInit } from '@angular/core';
import { FoodMenu } from '../menu-management/food-menu.model';
import { HttpClient } from '@angular/common/http';
import { FoodMenuServiceService } from '../services/food-menu-service.service';
import { faPlay,faGear } from '@fortawesome/free-solid-svg-icons';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {
  faPlay = faPlay;
  faGearComplex = faGear;
  toContact(){
  
  }
  slides = [
    {
      id: 1,
      image: '../../assets/chole-bhature-recipe.jpg',
      title: 'Slide 1',
      description: 'Description for Slide 1'
    },
    {
      id: 2,
      image: '../../assets/menu.png',
      title: 'Slide 2',
      description: 'Description for Slide 2'
    },
  ];

}