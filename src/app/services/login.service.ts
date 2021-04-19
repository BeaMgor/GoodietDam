import { LoginForm } from './../model/loginForm';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class LoginService{
    private token: string;
    constructor(
        private httpClient: HttpClient
    ){
        this.token = '';
    }

    public getToken(){
        return this.token;
    }

    public postlogin(loginModel: LoginForm){

        const httpOptions = {
            headers: new HttpHeaders(
                {
                    'Content-Type': 'application/json'
                }
            )
        };
        this.httpClient.post('http://localhost:8080/api/authenticate', JSON.stringify(loginModel), httpOptions).subscribe(
            (response: any) => {
                this.token = response.id_token;
            },
            error => {
                console.log(error);
            }
        );
    }
}
