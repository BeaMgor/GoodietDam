import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DetalleComponent } from './detalle.component';



@NgModule({
  declarations: [DetalleComponent],
  imports: [
    CommonModule, RouterModule
  ],
  exports: [
    DetalleComponent
  ]
})
export class DetalleModule { }
