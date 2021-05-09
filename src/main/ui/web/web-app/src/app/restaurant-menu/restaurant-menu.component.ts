import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {MenuService} from "../services/menu.service";
import { Observable} from "rxjs";
import {Restaurant} from "../models/restaurant";
import {catchError, tap} from "rxjs/operators";

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
  menuItem: any=[];
  private menu: any=[];
  public menulist: any=[];

  constructor(private activatedRoute: ActivatedRoute, private menuService: MenuService) {

  }

  ngOnInit(): void {
    this.id = this.activatedRoute.snapshot.paramMap.get('id');
    console.log(this.id);
    this.menuService.getRestaurantById(this.id).subscribe( data => {
      this.str = data.meniu, this.r = data,
        localStorage.setItem("str",this.str);

    });

    this.str=localStorage.getItem("str");
    this.splitted = this.str.split(","),
    console.log(this.splitted);


    let a;
    for (let i = 0; i < this.splitted.length; i++) {
      a = this.splitted[i];
      this.menuService.getMancareById(a).subscribe(data =>
        {
          this.menulist.push(data);


          localStorage.setItem("menu",JSON.stringify(this.menu));
          console.log(this.menulist);
            //aici trebuie sa salvez cumva meniul local
        }, err=>console.log(err)

      );
     //a=((localStorage.getItem("menu")));
    }
    let b=JSON.parse(<string>localStorage.getItem("menu"));

    //console.log(b);
  }


}
