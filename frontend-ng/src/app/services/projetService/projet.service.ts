import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Projet} from "../../models/Projet/projet";
import {basedUrl} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class ProjetService {

  constructor(private http: HttpClient) { }

  getProjects() : Observable<Projet[]> {
    return this.http.get<Projet[]>(`${basedUrl}projet/all`);
  }

  getProject(id: number): Observable<Projet> {
    return this.http.get<Projet>(`${basedUrl}projet/${id}`);
  }
}
