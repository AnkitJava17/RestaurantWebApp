import { Injectable } from '@angular/core';
import { FoodMenu } from '../menu-management/food-menu.model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FoodMenuServiceService {
  private apiUrl = 'http://localhost:8082/api/foodMenu';

  constructor(private http: HttpClient) { }

  getAllFoodMenus(): Observable<FoodMenu[]> {
    return this.http.get<FoodMenu[]>(this.apiUrl);
  }

  createFoodMenu(foodMenu: FoodMenu): Observable<FoodMenu> {
    return this.http.post<FoodMenu>(this.apiUrl, foodMenu);
  }

  deleteFoodMenu(name: String): Observable<Boolean> {
    const url = `${this.apiUrl}/${name}`;
    return this.http.delete<boolean>(url);
  }
}