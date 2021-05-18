import {Component, Input, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {OrderService} from "../services/order.service";
import {LoginService} from "../services/login.service";
import {Order} from "../models/Order";

@Component({
  selector: 'app-orderform',
  templateUrl: './orderform.page.html',
  styleUrls: ['./orderform.page.scss']
})
export class OrderformPage implements OnInit {
  public valid=1;
  public send: boolean;

  constructor(private orderService:OrderService, private loginService: LoginService) { this.send=false; }
  @Input() orderList:any;
  @Input() total:any;


  orderForm = new FormGroup({

    adresa: new FormControl('', Validators.required),
  });

  ngOnInit(): void {
    console.log(this.orderList)
  }

  onSubmit() {
    if (this.orderForm.valid)
      this.valid = 0;
    else
      this.valid = 1;

    if(this.loginService.loggedUser!=null && this.valid==0) {
      let user = this.loginService.loggedUser?.email;
      let Order1 = new Order(user, "", "", JSON.stringify(this.orderList), this.total, this.orderForm.controls.adresa.value, 0, "");
      this.orderService.addOrder(Order1);
      localStorage.removeItem('cookiename');
      this.send=true;
    }

  }
}
