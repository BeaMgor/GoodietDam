import { RecetasService } from './../../services/recetas.service';
import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { Router } from '@angular/router';
import { Receta } from 'src/app/model/receta';

@Component({
  selector: 'app-recetas',
  templateUrl: './recetas.component.html',
  styleUrls: ['./recetas.component.css']
})
export class RecetasComponent implements OnInit {

  public recetas: Array<Receta>;
  private sub: any;
  private subLogin: any;



  constructor(private loginService: LoginService,
    private recetaService: RecetasService,
    private router: Router) { 

      this.recetas = this.recetaService.getListaRecetas();
    }

  ngOnInit(): void {
    // nos subcribimos al observable antes de que se llame al getrecetas porque así me quedo escuchando con todo
    // preparado.
    this.sub = this.recetaService.getRecetasSub().subscribe(
      (response: Array<Receta>) => {
        console.log(response);
        this.recetas = response;

      },
      (error: any) => {
        console.log(error)
      } 
    );

    this.recetaService.getRecetas();
  }

  public getDetalle(id:number):void{
    console.log("Click"+id);

    this.recetaService.getDetalle(id);
    
  }


  /*tiene que ir función getDetalleReceta*/ 
  public getDetalleReceta(id: number): void {
    this.recetaService.getDetalle(id);
  }

  public irDetalle(id:any): void {
    this.router.navigate(["/detalle", id])
    this.recetaService.getDetalle(id);
  }

}
