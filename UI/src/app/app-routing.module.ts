import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ContactComponent } from './contact/contact.component';
import { MenuManagementComponent } from './menu-management/menu-management.component';
import { ReservationComponent } from './reservation/reservation.component';
import { MenuComponent } from './menu/menu.component';
import { RegisterComponent } from './register/register.component';
import { ProfileComponent } from './profile/profile.component';
import { LocationComponent } from './location/location.component';
import { FooterComponent } from './footer/footer.component';

const routes: Routes = [
  {path:"", pathMatch:'full', redirectTo:"dashboard"},
  {path:"dashboard", component:DashboardComponent},
  // {path:"login", component:LoginComponent},
  {path:"about", component:AboutComponent},
  {path:"contact", component:ContactComponent},
  {path:"menu", component:MenuComponent},
  {path:"reservation", component:ReservationComponent},
  {path:"admin", component:MenuManagementComponent},
  {path:"login", component:LoginComponent},
  {path:"register", component:RegisterComponent},
  {path:"profile", component:ProfileComponent},
  {path:"location", component:LocationComponent},
  {path:"footer", component:FooterComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
