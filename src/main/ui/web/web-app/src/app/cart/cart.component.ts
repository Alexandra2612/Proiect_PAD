import { Component, OnInit } from '@angular/core';
import {AppComponent} from "../app.component";
import {CartService} from "../services/cart.service";
import {CookieService} from "ngx-cookie-service";
import { MancareComanda } from '../models/MancareComanda';


@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cartProductList: any;
  newNumber: any;

  constructor(private cartService: CartService) {
  }

  ngOnInit(): void {

    this.cartProductList = this.cartService.getProductList();
    console.log(this.cartProductList)
    console.log(this.newNumber);

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
}
