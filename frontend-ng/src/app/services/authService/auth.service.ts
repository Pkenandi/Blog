import { Injectable } from '@angular/core';
import { JwtHelperService } from "@auth0/angular-jwt";
import {HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  helper = new JwtHelperService();

  constructor() { }

  getAccessToken(): string{
    return <string>localStorage.getItem("access_token");
  }

  getRefresh_token(){
    return <string>localStorage.getItem("access_token");
  }

  setToken(): void{
    localStorage.setItem('access_token', this.getAccessToken());
    localStorage.setItem('refresh_token', this.getRefresh_token())
  }

  getExpirationDate(){
    const access_token = localStorage.getItem('access_token');
    return this.helper.getTokenExpirationDate(access_token);
  }

  isTokenExpired(): boolean{
    const access_token = localStorage.getItem('access_token');
    return this.helper.isTokenExpired(access_token) && access_token != null;
  }

  public tokenInjector() {
    return {
      headers: new HttpHeaders()
        .set('AUTHORIZATION', 'Bearer ' + this.getAccessToken())
        .set('Content-Type', 'application/x-www-form-urlencoded'),
    };
  }

}
