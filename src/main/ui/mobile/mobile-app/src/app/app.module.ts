import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouteReuseStrategy } from '@angular/router';

import { IonicModule, IonicRouteStrategy } from '@ionic/angular';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import {RestaurantPage} from "./restaurant/restaurant.page";
import {RestaurantPageModule} from "./restaurant/restaurant.module";
import {RestaurantMenuPage} from "./restaurant-menu/restaurant-menu.page";
import {RestaurantMenuPageModule} from "./restaurant-menu/restaurant-menu.module";
import {HttpClient, HttpClientModule, HttpErrorResponse} from "@angular/common/http";

@NgModule({
  declarations: [AppComponent],
  entryComponents: [],
  imports: [BrowserModule, IonicModule.forRoot(), AppRoutingModule, RestaurantPageModule, HttpClientModule],
  providers: [{ provide: RouteReuseStrategy, useClass: IonicRouteStrategy }],
  bootstrap: [AppComponent],
})
export class AppModule {}
