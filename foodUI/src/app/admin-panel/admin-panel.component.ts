import { Component } from '@angular/core';
import { RouterService } from '../services/router.service';

@Component({
  selector: 'app-admin-panel',
  templateUrl: './admin-panel.component.html',
  styleUrls: ['./admin-panel.component.css']
})
export class AdminPanelComponent {

  constructor(private router:RouterService){}

  menuManage(){
    this.router.toMenuManage();
  }

  adminReserve(){
    this.router.toReservation();
  }
}
