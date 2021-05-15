import {Component, OnInit} from '@angular/core';
import {MancareComanda} from "./models/MancareComanda";
import {LoginService} from "./services/login.service";
import {User} from "./models/User";



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public loggeduser: User | undefined;

  constructor(private loginService:LoginService) {
  }

  ngOnInit(): void {
    this.loggeduser=this.loginService.loggedUser;
    console.log(this.loggeduser)
  }

  logout() {
    this.loginService.addLoggedUser(undefined);
    this.loggeduser=undefined;
  }

}
