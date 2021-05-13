import {Component, Input, OnInit} from '@angular/core';
import { Observable } from 'rxjs';
import {AppComponent} from "../app.component";
import {RestaurantsService} from "../services/restaurants.service";
import { Restaurant} from "../models/restaurant";
import {HttpErrorResponse, HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-restaurant',
  templateUrl: './restaurant.page.html',
  styleUrls: ['./restaurant.page.scss'],
})
export class RestaurantPage implements OnInit {
  restaurantid = 1;
  restaurant = 4;
  public restaurants: any= [];


  constructor(private restaurantService: RestaurantsService) {
  }
  id=1;

  ngOnInit(): void {

    this.restaurantService.getAll()
      .subscribe(data => {
          for (const d of (data as any)) {
            this.restaurants.push({
              id: this.id,
              nume: d.nume,
              imagine: d.imagine,
              adresa:d.adresa,
              descriere:d.descriere,
              meniu:d.meniu,


            });
            this.id+=1;
          }
          console.log(this.restaurants);
        }, err=>console.log(err)
      );

  }

}

