import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegistroComponent } from './registro.component';



@NgModule({
  declarations: [RegistroComponent],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule
  ],
  exports: [
    RegistroComponent
  ]
})
export class RegistroModule { }
