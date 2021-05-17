import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { LoginForm } from 'src/app/model/loginForm';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginModel: LoginForm;
  sub: any;


  constructor(
    private loginService: LoginService,
    private router: Router
  ) {
    this.loginModel = new LoginForm();
  }

  ngOnInit(): void {

    this.sub = this.loginService.getIsloginSub().subscribe(

      response=>{

        console.log(response);
        console.log("token recibido")
        this.router.navigate(['recetas']);
      },
      error=>{
        console.log(error);
        console.log("token busted")
      }
    );
  }


  public onSubmit(f: NgForm){
    this.loginService.postlogin(this.loginModel);
  }

}
