import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {AuthService} from "../authService/auth.service";
import {Education} from "../../models/Education/education";
import {Observable} from "rxjs";
import {basedUrl} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class EducationService {

  constructor(private http: HttpClient,
              private authService: AuthService) { }

  addEducation(education : Education): Observable<Education>{
    console.log(" Data service before: " ,education);
    const data = new FormData();
    data.set('start', "" + education.start)
    data.set('etablissement',education.etablissement);
    data.set('degree',education.degree);
    data.set('average',education.average);
    data.set('expected_end', "" + education.expected_end)
    data.set('current', education.current)
    console.log(" Data : " ,data);

    return this.http.post<Education>(`${basedUrl}edu/add`,data, this.authService.tokenInjector())
  }

  getEducations(): Observable<Education[]>{
    return this.http.get<Education[]>(`${basedUrl}edu/all`);
  }

  getOne(id: number): Observable<Education> {
    return this.http.get<Education>(`${basedUrl}edu/${id}`);
  }
}
