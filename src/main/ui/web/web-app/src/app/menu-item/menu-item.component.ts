import {AfterViewChecked, Component, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import {Mancare} from "../models/Mancare";
import {Topping} from "../models/Topping";
import {MancareComanda} from "../models/MancareComanda";
import {isNumeric} from "rxjs/internal-compatibility";
import {AppComponent} from "../app.component";
import {CartService} from "../services/cart.service";


@Component({
  selector: 'app-menu-item',
  templateUrl: './menu-item.component.html',
  styleUrls: ['./menu-item.component.css']
})

export class MenuItemComponent implements OnInit{




  constructor(private a:CartService) { }
  @Input()  item1: any;
  toppingchoose: any;


  ngOnInit(){
    console.log(this.item1)
  }

  itemchoose={} as MancareComanda;


  addItemInCart(item: Mancare) {
    this.itemchoose=({
      id: item.id,
      nume: item.nume,
      ingrediente: item.ingrediente,
      imagine:item.imagine,
      pret:item.pret,
      gramaj: item.gramaj,
      toppinguri: this.toppingchoose
    })
    console.log(this.itemchoose)
    this.a.addProductToCart(this.itemchoose);
  }

}
