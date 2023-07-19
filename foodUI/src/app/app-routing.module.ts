import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FooterComponent } from './footer/footer.component';
import { LocationComponent } from './location/location.component';
import { LoginComponent } from './login/login.component';
import { MenuManagementComponent } from './menu-management/menu-management.component';
import { MenuComponent } from './menu/menu.component';
import { AdminPanelComponent } from './admin-panel/admin-panel.component';

const routes: Routes = [
  {path:"", pathMatch:'full', redirectTo:"dashboard"},
  {path:"dashboard", component:DashboardComponent},
  // {path:"login", component:LoginComponent},
  {path:"about", component:AboutComponent},
  {path:"contact", component:ContactComponent},
  {path:"menu", component:MenuComponent},
  {path:"admin", component:AdminPanelComponent},
  {path:"login", component:LoginComponent},
  {path:"location", component:LocationComponent},
  {path:"footer", component:FooterComponent},
  {path:"menu-manage", component:MenuManagementComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
