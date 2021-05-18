import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { OrderformPageRoutingModule } from './orderform-routing.module';

import { OrderformPage } from './orderform.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    OrderformPageRoutingModule,
    ReactiveFormsModule
  ],
    exports: [
        OrderformPage
    ],
    declarations: [OrderformPage]
})
export class OrderformPageModule {}
