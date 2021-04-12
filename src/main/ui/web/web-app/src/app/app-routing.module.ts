import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from  '../app/login/login.component'
import { RegisterComponent } from '../app/register/register.component'
const  routes:  Routes  = [
  {path:  'auth', loadChildren:  './auth/auth.module#AuthModule'},
  {
    path: 'login',
    component: LoginComponent
  },


  {
    path: 'register',
    component: RegisterComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
