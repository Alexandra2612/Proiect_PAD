import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {RestaurantsService} from "./restaurants.service";
import {Observable} from "rxjs";
import {Restaurant} from "../models/restaurant";
import {tap} from "rxjs/operators";
import {Mancare} from "../models/Mancare";




@Injectable({
  providedIn: 'root'
})
export class MenuService {
  baseUrl = "http://localhost:8080/api/restaurant";
  constructor(private http:HttpClient) { }

  getRestaurantById(id: number): Observable<Restaurant>{
    return this.http.get<Restaurant>(`${this.baseUrl}/${id}`);
  }


  mancareurl="http://localhost:8080/api/menuItem";
  getMancareById(arrayElement: string) : Observable<Mancare>{


    //console.log(arrayElement);
    let a = this.http.get<Mancare>(`${this.mancareurl}/${arrayElement}`);
    //console.log(a);
    return a;

  }
}
