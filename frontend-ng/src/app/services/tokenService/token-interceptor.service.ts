import { Injectable, Injector } from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";
import { AuthService } from "../authService/auth.service";

@Injectable({
  providedIn: 'root'
})
export class TokenInterceptorService implements HttpInterceptor{

  constructor(private injector: Injector ) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let authService = this.injector.get(AuthService);
    const access_token = JSON.parse(localStorage.getItem("access_token"));
    const refresh_token = localStorage.getItem("refresh_token");

    let tokenizedRequest = req.clone({
      setHeaders: {
        AUTHORIZATION : `Bearer ${access_token}`
      }
    })

    return next.handle(tokenizedRequest);
  }
}
