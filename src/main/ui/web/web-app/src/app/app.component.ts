import { Component } from '@angular/core';
import {MancareComanda} from "./models/MancareComanda";



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'Food Delivery';
  //static currentUser = "alina";
  currentUser: boolean =false;
  notUser: any=true;

}
