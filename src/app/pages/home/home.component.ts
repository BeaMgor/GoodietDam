import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Receta } from 'src/app/model/receta';
import { LoginService } from 'src/app/services/login.service';
import { RecetasService } from 'src/app/services/recetas.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

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

    this.recetaService.getRecetas();
  }

  /*tiene que ir función getDetalleReceta*/ 
}


