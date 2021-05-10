import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {Observable, throwError} from "rxjs";
import {Restaurant} from "../models/restaurant";
import {catchError} from "rxjs/operators";


const baseUrl="http://localhost:8080/api/restaurant";
@Injectable({
  providedIn: 'root'
})

export class RestaurantsService {

  constructor(private http:HttpClient) { }

  getAll(){
    return this.http.get(baseUrl);
  }

}
