import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Restaurant} from "../models/restaurant";
import {User} from "../models/User";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private _loggedUser: User | undefined;

  constructor(private http:HttpClient) { }
  baseUrl = "http://localhost:8080/api/user/?email=";

  getUserByEmail(email: string){
    return this.http.get(this.baseUrl+email);
  }

  addLoggedUser(loggedElement: any) {
    this._loggedUser=loggedElement;
    localStorage.setItem('logeedUser',JSON.stringify(this._loggedUser));

  }
  get loggedUser(): User | undefined{
    this._loggedUser=JSON.parse(<string>localStorage.getItem('logeedUser'));

    console.log(this._loggedUser)
    return this._loggedUser;
  }

}
