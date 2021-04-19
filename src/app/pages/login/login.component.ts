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
  constructor(
    private loginService: LoginService
  ) {
    this.loginModel = new LoginForm();
  }

  ngOnInit(): void {
  }


  public onSubmit(f: NgForm){
    this.loginService.postlogin(this.loginModel);
  }

}
