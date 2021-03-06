import { Component, OnInit } from '@angular/core';
import {Profile} from "../../../models/Profile/profile";
import {ProfileService} from "../../../services/profileService/profile.service";
import {LangueService} from "../../../services/langueService/langue.service";
import {Langue} from "../../../models/Langue/langue";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  profile: Profile[] = [];
  langues: Langue[] = [];

  constructor(private profileService: ProfileService, private langueService: LangueService) { }

  ngOnInit(): void {
    this.getProfile();
  }

  getProfile(): void {
    this.profileService.getProfile()
      .subscribe(
        (profile) => {
           this.profile = profile;
        },
        (error) => {

        }
      )
    this.getLangues();

  }

  private getLangues() {
    this.langueService.getAll()
      .subscribe(
        (langues) => {
          this.langues = langues;
        }
      )
  }
}
