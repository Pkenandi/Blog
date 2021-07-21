import { Injectable } from '@angular/core';
import {HttpClient, HttpEvent} from "@angular/common/http";
import {Observable} from "rxjs";
import {basedUrl} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class FileService {

  constructor(private http: HttpClient) { }

  setPatientPic(formData: FormData, id: number): Observable<HttpEvent<string[]>>{
    return this.http.post<string[]>(`${basedUrl}profile/${id}/imgUrl`, formData, {
      reportProgress: true,
      observe: 'events'
    })
  }
}
