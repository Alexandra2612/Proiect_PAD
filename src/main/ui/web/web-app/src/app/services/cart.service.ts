import { Injectable } from '@angular/core';
import {MancareComanda} from "../models/MancareComanda";
import {CookieService}  from "ngx-cookie-service"

@Injectable({
  providedIn: 'root'
})
export class CartService {
  cartProductList = [];


 constructor(private cookieService:CookieService){
   //this.cartProductList=JSON.parse(this.cookieService.get('cookie-name'))
 }
  public addProductToCart(product: MancareComanda) {
    // const productExistInCart = this.cartProductList.find(({name}) => name === product.nume); // find product by name
    // if (!productExistInCart) {
    // @ts-ignore
    // @ts-ignore
    //this.cartProductList=JSON.parse(this.cookieService.get('cookie-name'));

    this.cartProductList.push(product); // enhance "porduct" opject with "num" property
   // this.cookieService.set('cookie-name',JSON.stringify(this.cartProductList));
    //return;
    console.log(this.cartProductList)
  }
  // productExistInCart.num += 1;

  removeProduct(product: { name: any; }) {
    this.cartProductList = this.cartProductList.filter(({name}) => name !== product.name)
  }

  getProductList() {
    //this.cartProductList=JSON.parse(this.cookieService.get('cookie-name'))
    console.log(this.cartProductList)
    return this.cartProductList;
  }
}
