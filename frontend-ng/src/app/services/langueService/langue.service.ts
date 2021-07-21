import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Langue} from "../../models/Langue/langue";
import {basedUrl} from "../../../environments/environment";
import {Observable} from "rxjs";
import {AdminService} from "../adminService/admin.service";

@Injectable({
  providedIn: 'root'
})
export class LangueService {

  constructor(private http: HttpClient, private adminService: AdminService) { }

  getAll() {
    return this.http.get<Langue[]>(`${basedUrl}langue/all`);
  }

  setLangue(langue: Langue): Observable<Langue>{
    let data = new URLSearchParams();
    data.set("name",langue.name);
    data.set("level",langue.level);

    let options = {
      headers: new HttpHeaders()
        .set('AUTHORIZATION','Bearer '+this.adminService.getAccessToken())
        .set('Content-Type','application/x-www-form-urlencoded'),
    };

    return this.http.post<Langue>(`${basedUrl}langue/add`, data, options);
  }
}
