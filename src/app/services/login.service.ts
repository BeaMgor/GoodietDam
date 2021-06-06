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


    public getToken(): string{
        return this.token;
    }

    public postlogin(loginModel: LoginForm){
        console.log(JSON.stringify(loginModel));

        const httpOptions = {
            headers: new HttpHeaders(
                {
                    
                    'Content-Type': 'application/json'
                }
            )
        };
        this.httpClient.post('/api/login', JSON.stringify(loginModel), httpOptions).subscribe(
            (response: any) => {
                console.log(response);
                this.token = response.token;
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