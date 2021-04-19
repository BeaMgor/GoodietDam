import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginModule } from './login/login.module';
import { RegistroModule } from './registro/registro.module';



@NgModule({
  declarations: [],
  imports: [
    CommonModule, 
    LoginModule,
    RegistroModule
  ],
  exports: [
    LoginModule,
    RegistroModule
  ]
})
export class PagesModule { }
