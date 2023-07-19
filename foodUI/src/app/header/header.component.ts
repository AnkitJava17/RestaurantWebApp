import { Component, OnInit } from '@angular/core';
import { RouterService } from '../services/router.service';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  loggedIn: any;
  constructor(private router:RouterService, private auth:LoginService){
  }

  ngOnInit(): void {
      this.auth.isLoggedIn.subscribe((status)=>{
        this.loggedIn = status;
      })
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

  login(){
    this.router.toLogin();
  }

  logout(){
    this.auth.logout();
    this.router.toDashboard();
  }
}
