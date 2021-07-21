import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Competence} from "../../models/Competence/competence";
import {Observable} from "rxjs";
import {AdminService} from "../adminService/admin.service";
import {basedUrl} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class CompetenceService {

  constructor(private http: HttpClient,
              private adminService: AdminService) { }

  set(competence: Competence): Observable<Competence>{
    let data = new URLSearchParams();
    data.set("name", competence.name);
    data.set("numberOfYear", competence.numberOfYear);

    let options = {
      headers: new HttpHeaders()
        .set('AUTHORIZATION','Bearer '+this.adminService.getAccessToken())
        .set('Content-Type','application/x-www-form-urlencoded'),
    };

    return this.http.post<Competence>(`${basedUrl}competence/add`,data.toString(), options)
  }

  getAll(): Observable<Competence[]>{
    return this.http.get<Competence[]>(`${basedUrl}competence/all`);
  }
}
