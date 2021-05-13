import { Injectable } from '@angular/core';
import {MancareComanda} from "../models/MancareComanda";


@Injectable({
  providedIn: 'root'
})
export class CartService {
  public cartProductList: any;


 constructor(){

 }
  public addProductToCart(product: MancareComanda) {

    this.cartProductList=JSON.parse(<string>localStorage.getItem('cookiename'))
    if(this.cartProductList==null)
      this.cartProductList=[];

    var ok=0;
    for( var i = 0; i < this.cartProductList.length; i++){

      if ( this.cartProductList[i].product.nume == product.nume ) {
        if(this.cartProductList[i].product.toppinguri)
          if(this.cartProductList[i].product.toppinguri.nume===product.toppinguri.nume)
          {   this.cartProductList[i].num+=1; ok=1;}

          else;
        else
        {this.cartProductList[i].num+=1; ok=1;}
      }
    }
    if(ok==0)  this.cartProductList.push({product: product, num: 1});

      localStorage.setItem('cookiename',JSON.stringify(this.cartProductList));
      console.log(this.cartProductList)
  }
  removeProduct(product:MancareComanda) {
    this.cartProductList=JSON.parse(<string>localStorage.getItem('cookiename'))

    for( var i = 0; i < this.cartProductList.length; i++){

      if ( this.cartProductList[i].product.nume == product.nume ) {
        if(this.cartProductList[i].product.toppinguri)
          if(this.cartProductList[i].product.toppinguri.nume===product.toppinguri.nume)
            this.cartProductList.splice(i, 1);
          else;
          else
          this.cartProductList.splice(i, 1);
      }
      console.log(this.cartProductList);
      console.log(product);

    }
    localStorage.setItem('cookiename',JSON.stringify(this.cartProductList));
 }
  getProductList() {
    this.cartProductList=JSON.parse(<string>localStorage.getItem('cookiename'));
    console.log(this.cartProductList)
    return this.cartProductList;
  }
}
