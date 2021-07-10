import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {AdminService} from "../../../services/adminService/admin.service";
import {LoginRequest} from "../../../models/Admin/Login/login-request";
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
              private route: Router) { }

  ngOnInit(): void {
  }

  login(): void{
    this.loginRequest = this.loginForm.value;
    this.adminService.login(this.loginRequest)
      .subscribe(
        (response) => {
          this.route.navigate(['admin/dashboard']).then();
        },
        (error : HttpErrorResponse) => {
        }
      )
  }
}
