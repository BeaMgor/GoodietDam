import { DetalleModule } from './detalle/detalle.module';
import { RecetasModule } from './recetas/recetas.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginModule } from './login/login.module';
import { RegistroModule } from './registro/registro.module';



@NgModule({
  declarations: [],
  imports: [
    CommonModule, 
    LoginModule,
    RegistroModule,
    RecetasModule,
    DetalleModule
  ],
  exports: [
    LoginModule,
    RegistroModule,
    RecetasModule,
    DetalleModule
  ]
})
export class PagesModule { }
