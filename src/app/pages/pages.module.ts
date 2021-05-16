import { RecetasModule } from './recetas/recetas.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginModule } from './login/login.module';
import { RegistroModule } from './registro/registro.module';
import { TerminosModule } from './terminos/terminos.module';
import { UsuarioModule } from './usuario/usuario.module';
import { HomeModule } from './home/home.module';



@NgModule({
  declarations: [],
  imports: [
    CommonModule, 
    LoginModule,
    RegistroModule,
    RecetasModule,
    TerminosModule,
    UsuarioModule,
    HomeModule
  ],
  exports: [
    LoginModule,
    RegistroModule,
    RecetasModule,
    TerminosModule,
    UsuarioModule,
    HomeModule
  ]
})
export class PagesModule { }
