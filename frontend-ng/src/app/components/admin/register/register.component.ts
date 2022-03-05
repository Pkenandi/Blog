import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Admin} from "../../../models/Admin/admin";
import {AdminService} from "../../../services/adminService/admin.service";
import {HttpErrorResponse} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  message = "";
  registerRequest!: Admin;

  registerForm = new FormGroup({
    username: new FormControl('',[Validators.required]),
    email: new FormControl('',[Validators.required]),
    adminId: new FormControl(this.randomString()),
    password: new FormControl('',[Validators.required]),
  });

  constructor(private adminService: AdminService,
              private route: Router) { }

  ngOnInit(): void {
  }

  register(): void {
    this.registerRequest = this.registerForm.value;
    this.adminService.register(this.registerRequest)
      .subscribe(
        (response) => {
          this.route.navigate(['admin/login']).then();
        },
        (error: HttpErrorResponse) => {
          this.message = "Sorry ! something went wrong !!!"
        }
      )
  }

  get registerControl() {
    return this.registerForm.controls;
  }

  randomString(): string {
    let text = "";
    let possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_@#~)]";

    for (let i = 0; i < 10; i++)
      text += possible.charAt(Math.floor(Math.random() * possible.length));

    return text;
  }

}
