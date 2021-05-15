import { Component, OnInit } from '@angular/core';
import {FormControl, FormsModule, ReactiveFormsModule} from '@angular/forms';
import { FormGroup} from '@angular/forms';
import { Validators } from '@angular/forms';
import {LoginService} from "../services/login.service";
import {User} from "../models/User";
import sha256 from "fast-sha256";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  public logged:any=[];
  public ok=true;
  public fail: boolean=false;
  public loggeduser: User | undefined;

  constructor(private  loginService:LoginService) { }

  ngOnInit(): void {
    this.loggeduser=this.loginService.loggedUser;
  }

 valid:any;
  profileForm = new FormGroup({
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
  });

  onSubmit() {
    this.logged = [];
    this.fail = true;
    if (this.profileForm.valid)
      this.valid = 0;
    else
      this.valid = 1;

    console.log(this.profileForm.controls.username.value)
    this.loginService.getUserByEmail(this.profileForm.controls.username.value).subscribe(data => {
        if (data != null) {
          for (const d of (data as any)) {
            this.logged.push({
              rol: d.rol,
              email: d.email,
              nickname: d.nickname,
              nume: d.nume,
              prenume: d.prenume,
              adrese: d.adrese,
              phone_number: d.phoneNumber,
              parola: d.parola,
            });
          }
          this.ok = false;

          let b=sha256(new TextEncoder().encode(this.profileForm.controls.password.value));
          let str="";
          b.forEach(ch=>{str=str+("0123456789abcdef"[Math.floor(ch/16)%16]);str=str+("0123456789abcdef"[ch%16]);});
          console.log(str);
          console.log()
          if(str==this.logged[0].parola)
            this.loginService.addLoggedUser(this.logged[0]);

        }
      }, err => {
        console.log("Nu s-a gasit" + err);
        this.fail = true;
      }
    );



  }

}
