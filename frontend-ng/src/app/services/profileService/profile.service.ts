import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Profile} from "../../models/Profile/profile";
import {basedUrl} from "../../../environments/environment";
import {AdminService} from "../adminService/admin.service";
import {AuthService} from "../authService/auth.service";

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor(private http: HttpClient, private adminService: AdminService, private authService: AuthService) { }

  getProfile(): Observable<Profile[]>{
    return this.http.get<Profile[]>(`${basedUrl}profile/all`);
  }

  setProfile(profile: Profile): Observable<Profile>{
    let data = new URLSearchParams();
    data.set("content",profile.content);

    let options = this.authService.tokenInjector();

    return this.http.post<Profile>(`${basedUrl}profile/add`, data.toString(), options);
  }
}
