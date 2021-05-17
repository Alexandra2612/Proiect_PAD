import { Component, OnInit } from '@angular/core';
import {AppComponent} from "../app.component";
import {CartService} from "../services/cart.service";
import { MancareComanda } from '../models/MancareComanda';
import {LoginService} from "../services/login.service";


@Component({
  selector: 'app-cart',
  templateUrl: './cart.page.html',
  styleUrls: ['./cart.page.scss']
})
export class CartPage implements OnInit {

  cartProductList: any;
  newNumber: any;

  constructor(private cartService: CartService, private loginService:LoginService) {
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

  send() {

  }
}
