import {Component, Input, OnChanges, OnDestroy, OnInit, Output, SimpleChanges} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {MenuService} from "../services/menu.service";
import {interval, Observable, Subscription} from "rxjs";
import {Restaurant} from "../models/restaurant";
import {catchError, tap} from "rxjs/operators";
import {ToppingService} from "../services/topping.service";
import {Mancare} from "../models/Mancare";
import {Topping} from "../models/Topping";

@Component({
  selector: 'app-restaurant-menu',
  templateUrl: './restaurant-menu.page.html',
  styleUrls: ['./restaurant-menu.page.scss']
})


export class RestaurantMenuPage implements  OnInit {


  private id: any;
  private str: any;
  public r: any = [];
  private splitted: any;
  private toppinglist: any = [];
  private top: any;
  public menulist: any = [];
  public topping: any = [];
  toppingchoose: any;
  private itemchoose: any;

  constructor(private activatedRoute: ActivatedRoute, private menuService: MenuService, private toppingService: ToppingService) {
  }

  ngOnInit(): void {

    this.id = this.activatedRoute.snapshot.paramMap.get('id');
    //console.log(this.id);

    this.menuService.getRestaurantById(this.id).subscribe(data => {
      this.str = data.meniu, this.r = data,
        localStorage.setItem("str", this.str);

    });

    this.str = localStorage.getItem("str");
    this.splitted = this.str.split(",");
    console.log(this.splitted);
    let a;
    for (let i = 0; i < this.splitted.length; i++) {
      a = this.splitted[i];


      this.menuService.getMancareById(a).subscribe(data => {

        this.toppinglist = data.toppinguri;
        this.top = this.toppinglist.split(",");

        let y;
        let x:any=[];
        this.topping.push([])
        for (let j = 0; j < this.top.length; j++) {
          y = this.top[j];
          this.toppingService.getToppingById(y).subscribe(d =>{
              this.topping[i].push(d);

            }
          );
        }

        data.toppinguri = this.topping[i];
        this.menulist.push(data);

      })

      this.getMenuList();
    }

  }


  getMenuList(){
    console.log(this.menulist);
    return this.menulist;
  }

  addItemInCart(item: Mancare) {
    this.itemchoose=item;
    this.itemchoose.toppinguri=this.toppingchoose
    console.log(item);
  }
  getRestaurant(){
    return this.r;
  }
}
