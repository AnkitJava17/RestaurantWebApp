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
      photo: ['', Validators.required],
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
      window.location.reload();
    }
  }
  handleFileSelection(event: Event) {
    const fileInput = event.target as HTMLInputElement;
    const files = fileInput.files;

    if (files && files.length > 0) {
      const selectedFile = files[0];
      console.log('Selected file:', selectedFile);

      // Access file properties
      console.log('File name:', selectedFile.name);
      console.log('File type:', selectedFile.type);
      console.log('File size:', selectedFile.size);
    }
  }

  deleteFoodMenu(foodMenu: any) {
    console.log(this.foodService.deleteFoodMenu(foodMenu.name).subscribe());
    window.location.reload();
  }
  selectedFileName: string = 'No file chosen';

  onFileSelected(event: any) {
    const file: File = event.target.files[0];
    this.selectedFileName = file ? file.name : 'No file chosen';
    const fileInput = document.getElementById('input-file-id');
    // fileInput.addEventListener('change', this.handleFileSelection);
  }

  trimStringReverse(str: string, char: string): string {
    const index = str.lastIndexOf(char);
    if (index !== -1) {
      return str.substring(index + 1);
    }
    return str;
  }
}
