import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatCardModule} from '@angular/material/card';
import { MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import { LoginComponent } from './login/login.component';
import {MatMenuModule} from '@angular/material/menu';
import {Router, RouterModule} from "@angular/router";
import { HomeComponent } from '../app/home/home.component';
import { RestaurantsComponent } from './restaurants/restaurants.component';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatInputModule} from '@angular/material/input';
import { RestaurantMenuComponent } from './restaurant-menu/restaurant-menu.component';
import {ChartComponent} from "./chart/chart.component";
import {MatCell, MatCellDef, MatHeaderCell, MatTableModule} from "@angular/material/table";
import {MatPaginatedTabHeader} from "@angular/material/tabs/paginated-tab-header";
import {MatPaginatorModule} from "@angular/material/paginator";
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { CommonModule } from '@angular/common';
import  {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    HomeComponent,
    RestaurantsComponent,
    RestaurantMenuComponent,
    ChartComponent,
    PageNotFoundComponent,

  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatButtonModule,
    MatIconModule,
    MatMenuModule,
    RouterModule,
    MatGridListModule,
    MatInputModule,
    MatTableModule,
    MatPaginatorModule,
    ReactiveFormsModule,
    CommonModule,
    HttpClientModule,



  ],
  providers: [],
  bootstrap: [AppComponent],
  exports: [
    FormsModule,
    ReactiveFormsModule]
})
export class AppModule { }
