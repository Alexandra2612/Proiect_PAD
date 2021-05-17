import { Injectable } from '@angular/core';
import {Order} from "../models/Order";
import {Observable} from "rxjs";
import {NormalUser} from "../models/NormalUser";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http:HttpClient) { }

  addOrder(order: Order) {
    console.log(order);
    return this.sendPostRequest(order).subscribe(res=>console.log(res));
  }
  sendPostRequest(data: any): Observable<Order> {
    const baseUrl="http://localhost:8080/api/order"
    return this.http.post<Order>(baseUrl, data);

  }
}
