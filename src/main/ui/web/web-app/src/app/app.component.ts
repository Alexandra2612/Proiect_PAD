import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'Food Delivery';
  //static currentUser = "alina";
  notUser =false;
  currentUser: boolean =true;

  logout_alert() {
    this.currentUser=false;
    this.notUser=true;
  }
}
