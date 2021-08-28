import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {AdminService} from "../../../services/adminService/admin.service";
import {LoginRequest} from "../../../models/Admin/Login/loginRequest";
import {Router} from "@angular/router";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginRequest!: LoginRequest;

  loginForm = new FormGroup({
    username: new FormControl(''),
    password: new FormControl('')
  });

  constructor(private adminService: AdminService,
              private route: Router) {  }

  ngOnInit(): void {
  }

  login(): void{
    this.loginRequest = this.loginForm.value;
    this.adminService.login(this.loginRequest.username, this.loginRequest.password)
      .subscribe(
        (response) => {
          this.adminService.saveToken(response.refresh_token, response.access_token);
          this.route.navigate(['admin/dashboard']).then();
        },
        (error : HttpErrorResponse) => {
          console.log(" Erreur : ",error)
        }
      )
  }
}
