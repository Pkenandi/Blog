import { Injectable } from '@angular/core';
import {LoginRequest} from "../../models/Admin/Login/login-request";
import {Observable} from "rxjs";
import {Admin} from "../../models/Admin/admin";
import {HttpClient} from "@angular/common/http";
import {basedUrl} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient) { }

  login(login: LoginRequest): Observable<Admin>{
    return this.http.post<Admin>(`${basedUrl}admin/login`,login);
  }

  register(register: Admin): Observable<Admin>{
    return this.http.post<Admin>(`${basedUrl}admin/register`,register)
  }

}
