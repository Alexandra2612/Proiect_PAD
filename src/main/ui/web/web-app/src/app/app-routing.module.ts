// @ts-ignore
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from  '../app/login/login.component'
import { RegisterComponent } from '../app/register/register.component'
import {HomeComponent} from "./home/home.component"
import {RestaurantsComponent} from "./restaurants/restaurants.component";
import {RestaurantMenuComponent} from "./restaurant-menu/restaurant-menu.component";
import {CartComponent} from "./cart/cart.component";
import {PageNotFoundComponent} from "./page-not-found/page-not-found.component";


const  routes:  Routes  = [
  {path:  'auth', loadChildren:  './auth/auth.module#AuthModule'},
  { path: '', component: HomeComponent},
  {
    path: 'login',
    component: LoginComponent
  },

  {
    path: 'restaurant',
    component:RestaurantsComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'restaurant/:id', component: RestaurantMenuComponent
  },
  {
    path: 'cart', component : CartComponent
  },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
