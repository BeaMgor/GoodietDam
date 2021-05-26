
import { DetalleModule } from './../detalle/detalle.module';
import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home.component';
import { RecetasModule } from '../recetas/recetas.module';



@NgModule({
  declarations: [
    HomeComponent],
  imports: [
    CommonModule,
    RouterModule,
    DetalleModule,
    
    RecetasModule,
  ],
  exports: [
    HomeComponent
  ]
})
export class HomeModule { }
