import { Subject, Observable } from 'rxjs';
import { LoginForm } from './../model/loginForm';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class LoginService{
    private token: string;
    private islogin: boolean;
    private islogin$: Subject<boolean>;

    constructor(
        private httpClient: HttpClient
    ){
        this.token = '';
        this.islogin = false;
        this.islogin$ = new Subject<boolean>();
    }

    public getIsLogin(): boolean{
        return this.islogin;
    }

    public getIsloginSub(): Observable<any>{
        return this.islogin$.asObservable();
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
                this.islogin = true;
                this.islogin$.next(this.islogin);
            },
            error => {
                console.log(error);
            }
        );
    }

    public logout():void{
        this.islogin = false;
        this.token = "";
        this.islogin$.next(this.islogin);
    }
}
