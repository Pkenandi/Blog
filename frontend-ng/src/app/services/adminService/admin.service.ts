import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Admin} from "../../models/Admin/admin";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {basedUrl, loginUrl} from "../../../environments/environment";
import {LoginRequest} from "../../models/Admin/Login/loginRequest";
import {AuthService} from "../authService/auth.service";

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  access_token = "";
  refresh_token = "";
  isLoggedIn = false;

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded',
      'AUTHORIZATION': `Bearer ${this.getAccessToken()}`
    })
  };

  constructor(private http: HttpClient,
              private authService: AuthService) { }

  // Login and register

  login(username: string, password: string): Observable<any>{
    let body = new URLSearchParams();
    body.set('username', username);
    body.set('password', password)

    let options = {
      headers: new HttpHeaders()
        .set('Content-Type', 'application/x-www-form-urlencoded')
    };
    return this.http.post<any>(`${loginUrl}`,body.toString(), options);
  }

  register(register: Admin): Observable<Admin>{
    return this.http.post<Admin>(`${basedUrl}admin/register`,register)
  }

  // Operations
  setProfile(username: string, id: number): Observable<Admin>{
    return this.http.get<Admin>(`${basedUrl}admin/${username}/${id}/addProfile`, this.httpOptions);
  }

  setInterest(username: string, id: number): Observable<Admin>{
    return this.http.get<Admin>(`${basedUrl}admin/${username}/${id}/addInterest`, this.httpOptions);
  }

  setCompetence(username: string, id: number): Observable<Admin>{
    return this.http.get<Admin>(`${basedUrl}admin/${username}/${id}/addCompetence`, this.httpOptions);
  }

  setEducation(admin: string, id: number): Observable<Admin> {
    return this.http.get<Admin>(`${basedUrl}/admin/${admin}/${id}/addEducation`, this.httpOptions);
  }

  setLangue(username: string, id: number) {
    return this.http.get<Admin>(`${basedUrl}admin/${username}/${id}/addLangue`, this.httpOptions);
  }

  // Tokens
  saveToken(refresh_token: string, access_token: string){
    localStorage.setItem("access_token", access_token);
    localStorage.setItem("refresh_token", refresh_token);
    this.access_token = access_token;
    this.refresh_token = refresh_token;
    this.isLoggedIn = true;
  }

  getAccessToken(): string{
    return <string>localStorage.getItem("access_token");
  }

  getRefreshToken(): string {
    return <string>localStorage.getItem("refresh_token");
  }

  autoSendRefreshToken(): void{
    setTimeout(() => {
      let options = {
        headers: new HttpHeaders()
          .set('Content-Type', 'application/x-www-form-urlencoded')
          .set('AUTHORIZATION', `Bearer ${JSON.stringify(localStorage.getItem('refresh_token'))}`)
      };
      this.http.get(`${basedUrl}token/refresh`, options)
        .subscribe(
          (response) => {
            localStorage.clear();
            localStorage.setItem("access_token", response['access_token']);
            localStorage.setItem("refresh_token", response['refresh_token']);
          }
        )

      }, this.authService.getExpirationDate().getMilliseconds());
  }

}
