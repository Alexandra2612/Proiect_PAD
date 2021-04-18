import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'Food Delivery';
  //static currentUser = "alina";
  notUser =true;
  currentUser=false;

}
