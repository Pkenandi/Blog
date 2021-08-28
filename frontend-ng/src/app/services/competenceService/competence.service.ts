import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Competence} from "../../models/Competence/competence";
import {Observable} from "rxjs";
import {AdminService} from "../adminService/admin.service";
import {basedUrl} from "../../../environments/environment";
import {AuthService} from "../authService/auth.service";

@Injectable({
  providedIn: 'root'
})
export class CompetenceService {

  constructor(private http: HttpClient,
              private adminService: AdminService,
              private authService: AuthService) { }

  setCompetence(competence: Competence): Observable<Competence>{
    let data = new URLSearchParams();
    data.set("name", competence.name);
    data.set("numberOfYear", competence.numberOfYear.toString());

    let options = this.authService.tokenInjector();

    return this.http.post<Competence>(`${basedUrl}competence/add`,data.toString(), options)
  }

  getAll(): Observable<Competence[]>{
    return this.http.get<Competence[]>(`${basedUrl}competence/all`);
  }
}
