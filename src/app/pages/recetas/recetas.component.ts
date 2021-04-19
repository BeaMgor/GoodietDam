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
        this.recetas = response;

      },
      (error: any) => {
        console.log(error)
      }
      
    );
  }

  public deleteReceta(id: number): void {
    console.log('Click ' + id);

    // Este metodo es el que se va a encargar de llamar al metodo del html que se encargara de llamar la API
    // y comunicarle que un elemento ha siod eliminado.
    this.recetaService.deleteReceta(id);
  }

}
