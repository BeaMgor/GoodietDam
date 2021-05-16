import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsuarioComponent } from './usuario.component';



@NgModule({
  declarations: [UsuarioComponent],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule
  ]
})
export class UsuarioModule { }
