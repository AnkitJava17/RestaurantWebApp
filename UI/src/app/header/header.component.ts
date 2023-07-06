import { Component } from '@angular/core';
import { RouterService } from '../services/router.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  constructor(private router:RouterService){

  }
  about(){
    this.router.toAbout();
  }
  menu(){
    this.router.toMenu();
  }
  contact(){
    this.router.toContact();
  }
  reserve(){
    this.router.toReservation();
  }

  location(){
    this.router.toLocation();
  }
}
