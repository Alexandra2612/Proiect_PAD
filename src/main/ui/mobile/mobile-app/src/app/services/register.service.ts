import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import sha256, { Hash, HMAC } from "fast-sha256";
import {ValueConverter} from "@angular/compiler/src/render3/view/template";
import {User} from "../models/User";
import {NormalUser} from "../models/NormalUser"
import {catchError, tap} from "rxjs/operators";
import {Observable} from "rxjs";
@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  registered: User | undefined
  constructor(private http:HttpClient) { }

  getAllUsers(){
    const baseUrl="http://localhost:8080/api/user";
    return this.http.get(baseUrl);
  }

  register(email: string,name:string, password :string) {

    const baseUrl="http://localhost:8080/api/user"
    let b=sha256(new TextEncoder().encode(password));
    let str="";
    b.forEach(ch=>{str=str+("0123456789abcdef"[Math.floor(ch/16)%16]);str=str+("0123456789abcdef"[ch%16]);});
    console.log(str);
    this.registered=new NormalUser("",email,"",name,str,"","","c");
    console.log(JSON.stringify(this.registered) )
    return this.sendPostRequest(this.registered).subscribe(res=>console.log(res));

  }
  sendPostRequest(data: any): Observable<NormalUser> {
    const baseUrl="http://localhost:8080/api/user"
    return this.http.post<NormalUser>(baseUrl, data);
  }


}
