import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RouterService {
  
  constructor(private router: Router) {}

  toDashboard() {
    return this.router.navigate(['dashboard']);
  }
  toLogin() {
    return this.router.navigate(['login']);
  }
  toContact() {
    return this.router.navigate(['contact']);
  }
  toAbout() {
    return this.router.navigate(['about']);
  }
  toMenu(){
    return this.router.navigate(['menu']);
  }
  toReservation(){
    return this.router.navigate(['reservation'])
  }
  toLocation(){
    return this.router.navigate(['location']);
  }
}
