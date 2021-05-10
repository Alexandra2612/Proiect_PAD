import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Restaurant} from "../models/restaurant";
import {Topping} from "../models/Topping";

@Injectable({
  providedIn: 'root'
})
export class ToppingService {

  constructor(private http:HttpClient) {

  }
  baseUrl = "http://localhost:8080/api/topping";
  getToppingById(id: string): Observable<Topping>{
    return this.http.get<Topping>(`${this.baseUrl}/${id}`);
  }
}
