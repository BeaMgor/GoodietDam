import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TerminosComponent } from './terminos.component';

@NgModule({
    declarations: [
        TerminosComponent],
        
    imports: [ 
        CommonModule,
        RouterModule ],

    exports: [TerminosComponent],

    providers: [],
})
export class TerminosModule {}