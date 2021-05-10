import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {MenuService} from "../services/menu.service";
import { Observable} from "rxjs";
import {Restaurant} from "../models/restaurant";
import {catchError, tap} from "rxjs/operators";
import {ToppingService} from "../services/topping.service";
import {Mancare} from "../models/Mancare";
import {Topping} from "../models/Topping";

@Component({
  selector: 'app-restaurant-menu',
  templateUrl: './restaurant-menu.component.html',
  styleUrls: ['./restaurant-menu.component.css']
})

export class RestaurantMenuComponent implements OnInit {
  r: any=[];
  private id: any;
  str: any = [];
  private x: string | undefined;
  splitted :Array<any>= [];
  private menu: any=[];
  public menulist:any=[]
  toppinglist: any=[];
  top:Array<any>= [];
  public topping: Array<Topping>=[];
  private toppingfinal: any;
  private w: any;


  constructor(private activatedRoute: ActivatedRoute, private menuService: MenuService, private toppingService: ToppingService) {

  }

  ngOnInit(): void {
    this.id = this.activatedRoute.snapshot.paramMap.get('id');
    //console.log(this.id);
    this.menuService.getRestaurantById(this.id).subscribe( data => {
      this.str = data.meniu, this.r = data,
        localStorage.setItem("str",this.str);

    });

    this.str=localStorage.getItem("str");
    this.splitted = this.str.split(",");
    //console.log(this.splitted);

    let a;
    for (let i = 0; i < this.splitted.length; i++) {
      a = this.splitted[i];
      this.menuService.getMancareById(a).subscribe(data =>
        {

          this.toppinglist=data.toppinguri;
          this.top=this.toppinglist.split(",");
          console.log(this.top);
          let y;
          for(let j=0; j< this.top.length; j++){
             y=this.top[j];
            this.toppingService.getToppingById(y).subscribe(d=> {
              this.topping.push(d);
              if (j==this.top.length-1)
              {
                localStorage.setItem("toppingitem",JSON.stringify(this.topping)),
                  this.topping=[];
              }
              }, err1=>console.log(err1))
            //trebuie retinute toppigurile cumva intr-o lista
            //console.log(JSON.parse(<string>localStorage.getItem("toppingitem")));
          }
          this.w=JSON.parse(<string>localStorage.getItem("toppingitem"));
          console.log(this.w);
          data.toppinguri=this.w;
          this.w=[];
          this.menulist.push(data);
          //localStorage.setItem("menu",JSON.stringify(this.menu));
          console.log(this.menulist);

            //aici trebuie sa salvez cumva meniul local
        }, err=>console.log(err)

      );

    }
    }
}
