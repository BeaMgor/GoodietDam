import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { registroForm } from 'src/app/model/registroForm';
import { RegistroService } from 'src/app/services/registro.service';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {

  public registroModel: registroForm;
  public msg: string;
  public msg2: string;
  public ok: boolean;

  constructor(
    private registroService: RegistroService // así tenemos el service inyectado dentro de los parametros del constructor
  ) {
    this.registroModel = new registroForm();
    this.msg = '';
    this.msg2 = '';
    this.ok = true;
   }

  ngOnInit(): void {
  }

  // función para mostrar los datos recogido en el ngForm - onSubmit del html. Util para hacer validadciones
  onSubmit(f: NgForm): void {
    console.log('RegisterService');
    // validacion
    if (this.registroModel.password.length < 6){
      this.ok = false;
      this.msg = 'La contraseña tiene que ser mayor a 6 caracteres';
    }else if (this.registroModel.password !== this.registroModel.password2){
      this.ok = false;
      this.msg2 = 'Las contraseñas no coinciden';
    }else{
      // con nuestro servicio llamamos a un metodo al que le estamos pasando un objeto que es registerModel.
      this.registroService.sendRegister(this.registroModel);
    }
  }

}
