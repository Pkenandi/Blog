import {Component, OnInit} from '@angular/core';
import {Profile} from "../../../../models/Profile/profile";
import {ProfileService} from "../../../../services/profileService/profile.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {AdminService} from "../../../../services/adminService/admin.service";
import {HttpErrorResponse} from "@angular/common/http";
import {LangueService} from "../../../../services/langueService/langue.service";
import {Langue} from "../../../../models/Langue/langue";

@Component({
  selector: 'app-add-profile',
  templateUrl: './add-profile.component.html',
  styleUrls: ['./add-profile.component.css']
})
export class AddProfileComponent implements OnInit {

  profile!: Profile;
  username = "Prince";

  profileForm = new FormGroup({
    content: new FormControl('', Validators.required),
  })

  constructor(private profileService: ProfileService,
              private adminService: AdminService,
              private langueService: LangueService) {
  }

  ngOnInit(): void {
    this.getProfile("Prince");
  }

  getProfile(username: string): void {
    this.profileService.getProfile(username)
      .subscribe(
        (profile) => {
          this.profile = profile;
        },
        (error) => {

        }
      )
  }

  setProfile(): void {
    this.profile = this.profileForm.value;
    if (this.profile.content != "") {
      this.profileService.setProfile(this.profile)
        .subscribe(
          (profile) => {
            this.adminService.setProfile("Prince", profile.id)
              .subscribe(
                (success) => {
                    this.getProfile(this.username);
                    console.log(success);
                },
                (error : HttpErrorResponse) => {
                  console.log(" Erreur 1 : ", error)
                }
              )
          },
          (error: HttpErrorResponse) => {
            console.log(" Erreur 2 : ", error);
          }
        )
    }
  }

}
