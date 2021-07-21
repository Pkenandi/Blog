import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Profile} from "../../models/Profile/profile";
import {basedUrl} from "../../../environments/environment";
import {AdminService} from "../adminService/admin.service";

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor(private http: HttpClient, private adminService: AdminService) { }

  getProfile(username: string): Observable<Profile>{
    return this.http.get<Profile>(`${basedUrl}profile/${username}/profile`);
  }

  setProfile(profile: Profile): Observable<Profile>{
    let data = new URLSearchParams();
    data.set("content",profile.content);

    let options = {
      headers: new HttpHeaders()
        .set('AUTHORIZATION','Bearer '+ this.getAccessToken())
        .set('Content-Type','application/x-www-form-urlencoded'),
    };

    return this.http.post<Profile>(`${basedUrl}profile/add`, data.toString(), options);
  }

  getAccessToken(): string{
    return <string>localStorage.getItem("access_token");
  }

  getRefreshToken(): string{
    return JSON.stringify(localStorage.getItem("refresh_token"));
  }
}
