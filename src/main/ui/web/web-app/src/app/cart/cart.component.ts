import { Component, OnInit } from '@angular/core';
import {AppComponent} from "../app.component";
import {CartService} from "../services/cart.service";
import {CookieService} from "ngx-cookie-service";



@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cartProductList: any=[];
  constructor(private cartService:CartService) { }

  ngOnInit(): void {

      this.cartProductList=this.cartService.getProductList();
      console.log(this.cartProductList)

  }

}
