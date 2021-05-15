import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {RegisterService} from "../services/register.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  private listofusers: any=[];
  private exist: any;
  public usernameExists: boolean=false;
  public valid: boolean=true;
  public succes: boolean=false;

  constructor(private registerService:RegisterService) { }

  ngOnInit(): void {
  }
  registerForm = new FormGroup({
    nume: new FormControl('', Validators.required),
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
  });


  onSubmit() {
    console.log(this.registerForm.controls.username.value);
    if (this.registerForm.valid) {


      this.registerService.getAllUsers().subscribe(data => {
        if (data != null) {
          for (const d of (data as any)) {
            this.listofusers.push({
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
        }
      }, err => {
        console.log(err)
      })
      console.log(this.listofusers);
      if (this.listofusers.length != 0) {
        this.exist = this.listofusers.filter((d: { email: any; }) => this.registerForm.controls.username.value === d.email);
        if (this.exist == null) {
          this.registerService.register(this.registerForm.controls.username.value, this.registerForm.controls.nume.value, this.registerForm.controls.password.value);
          this.succes=true;
        }
        else this.usernameExists = true;
      }
      if (this.listofusers.length == 0) {
        this.registerService.register(this.registerForm.controls.username.value, this.registerForm.controls.nume.value, this.registerForm.controls.password.value);
        this.succes=true;
      }
    }
    else this.valid=false;
  }
}
