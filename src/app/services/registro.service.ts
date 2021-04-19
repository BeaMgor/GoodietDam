

import { Injectable } from "@angular/core";
import { registroForm } from "../model/registroForm";

// servico que obtenga el objeto register

@Injectable()
export class RegistroService{
    constructor(){}

    // metodo de nuestro servicio. que recibe el objeto registerForm
    public sendRegister(data: registroForm): void{
        console.log('RegisterService');
        console.log(JSON.stringify(data));
        console.log(data);
        alert('Registro realizado');
    }
}