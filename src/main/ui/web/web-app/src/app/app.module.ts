import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';

import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import {MatCardModule} from '@angular/material/card';
import { MatButtonModule} from '@angular/material/button';


import {MatIconModule} from '@angular/material/icon';
import { LoginComponent } from './login/login.component';
import {MatMenuModule} from '@angular/material/menu';
import {Router, RouterModule} from "@angular/router";
import { HomeComponent } from './home/home.component';



@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    HomeComponent,



  ],
  imports: [
    BrowserModule,
    AppRoutingModule,

    FormsModule,

    BrowserAnimationsModule,
    MatCardModule,
    MatButtonModule,
    MatIconModule,
    MatMenuModule,
    RouterModule,
    ReactiveFormsModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
