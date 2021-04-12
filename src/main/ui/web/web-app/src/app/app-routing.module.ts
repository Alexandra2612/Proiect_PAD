import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from  '../app/login/login.component'
import { RegisterComponent } from '../app/register/register.component'
import {HomeComponent} from "./home/home.component"
import {RestaurantsComponent} from "./restaurants/restaurants.component";
const  routes:  Routes  = [
  {path:  'auth', loadChildren:  './auth/auth.module#AuthModule'},
  { path: '', component: HomeComponent},
  {
    path: 'login',
    component: LoginComponent
  },

  {
    path: 'restaurants',
    component:RestaurantsComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
