import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
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
    let data = new URLSearchParams();
    data.set("etablissement",education.etablissement);
    data.set("degree",education.degree);
    data.set("average",education.average);
    data.set("start",String(education.start))
    data.set("expected_end",String(education.expected_end))
    data.set("current", String(education.current))

    return this.http.post<Education>(`${basedUrl}edu/add`,data.toString(), this.authService.tokenInjector())
  }

  getEducations(): Observable<Education[]>{
    return this.http.get<Education[]>(`${basedUrl}edu/all`);
  }
}
