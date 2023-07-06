import { Component } from '@angular/core';
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
}