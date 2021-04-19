import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RecetasComponent } from './recetas.component';



@NgModule({
  declarations: [RecetasComponent],
  imports: [
    CommonModule,
    RouterModule
  ],
  exports: [
    RecetasComponent
  ]
})
export class RecetasModule { }
