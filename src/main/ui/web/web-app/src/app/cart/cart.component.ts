import { Component, OnInit } from '@angular/core';
import {AppComponent} from "../app.component";
import {CartService} from "../services/cart.service";
import {CookieService} from "ngx-cookie-service";
import { MancareComanda } from '../models/MancareComanda';
import {LoginService} from "../services/login.service";


@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cartProductList: any;
  newNumber: any;
  isLogged:boolean;

  constructor(private cartService: CartService, private loginService:LoginService) {
    if( localStorage.getItem("loggedUser") == null)
    {
      console.log("UNDEFINED")
      this.isLogged=false
    }
    else this.isLogged=true;
  }

  ngOnInit(): void {

    this.cartProductList = this.cartService.getProductList();

  }

  remove(item: MancareComanda) {
    this.cartService.removeProduct(item);
  }
  getTotal(){
    let total=0;
    for( var i = 0; i < this.cartProductList.length; i++){
      total+=this.cartProductList[i].num*this.cartProductList[i].product.pret;
    }
    return total;

}

  send() {
   if( localStorage.getItem("loggedUser") == null)
      {
        console.log("UNDEFINED")
        this.isLogged=false
      }
   else this.isLogged=true;

  }
}
