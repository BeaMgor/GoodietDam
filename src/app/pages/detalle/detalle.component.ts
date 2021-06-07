import { Component, OnInit } from '@angular/core';
import { Receta } from 'src/app/model/receta';
import { LoginService } from 'src/app/services/login.service';
import { RecetasService } from 'src/app/services/recetas.service';

@Component({
  selector: 'app-detalle',
  templateUrl: './detalle.component.html',
  styleUrls: ['./detalle.component.css']
})
export class DetalleComponent implements OnInit {

  public recetas: Array<Receta>;

  constructor(private loginService: LoginService,
    private recetaService: RecetasService) { 

      this.recetas = this.recetaService.getListaRecetas();
    }

  ngOnInit(): void {

  }

}
