import { Receta } from './../model/receta';
import { Injectable } from "@angular/core";
import { Observable, Subject } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { LoginService } from './login.service';




@Injectable({
    providedIn: 'root'
})
export class RecetasService {
    // Aqui hacemos la peticion GET al endpoint que devolvera la lista de recetas
    // nos declaramos un array de recetas

    private recetas: Array<Receta>;
    private recetas$: Subject<Array<Receta>>;

    constructor(
        private httpClient: HttpClient,
        private loginService: LoginService
    ){
        this.recetas = new Array<Receta>();
        this.recetas$ = new Subject<Array<Receta>>();
    }

    public getRecetasSub(): Observable<any>{
        return this.recetas$.asObservable();
    }

    public getListaRecetas(): Array<Receta>{
        return this.recetas;
    }

    //aquí va el método que llama a la api. Faltan urls de las Api (Laura, Sara)
  
    public getRecetas(): void {
       
        const httpOptions = {
            headers: new HttpHeaders(
                {

                    // tslint:disable-next-line: object-literal-key-quotes
                    'Authorization': 'Bearer ' + this.loginService.getToken(),

                    'Content-Type': 'application/json'
                }
            )
        };

        //httpclient, con la url de la api

        this.httpClient.get("/api/recipes", httpOptions).subscribe(
            (response: any) => {
                console.log(JSON.stringify(response))
                this.recetas = response;
                this.recetas$.next(this.recetas);
            },
            error => {
                console.log(error);
                console.log("Usuario no identificado")
            }
        );

    }

    


    //Aquí el método que lleva al detalle de la receta. (Félix)

}