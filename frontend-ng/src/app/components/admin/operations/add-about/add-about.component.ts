import { Component, OnInit } from '@angular/core';
import {Langue} from "../../../../models/Langue/langue";
import {FormControl, FormGroup} from "@angular/forms";
import {LangueService} from "../../../../services/langueService/langue.service";
import {AdminService} from "../../../../services/adminService/admin.service";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-add-about',
  templateUrl: './add-about.component.html',
  styleUrls: ['./add-about.component.css']
})
export class AddAboutComponent implements OnInit {

  langue!:Langue;
  langues: Langue[] = [];

  langueForm = new FormGroup({
    name: new FormControl(''),
    level: new FormControl('')
  })

  constructor(private langueService: LangueService, private adminService: AdminService) { }

  ngOnInit(): void {
    this.getLangues();
  }

  setLangue(): void {
    this.langue = this.langueForm.value;
    this.langueService.setLangue(this.langue)
      .subscribe(
        (langue) => {
          this.adminService.setLangue("Prince",langue.id)
            .subscribe(
              (success) => {
                this.langueForm.reset({});
                this.getLangues();
              },
              (error: HttpErrorResponse) => {
                console.log(error);
              }
            )
        }
      )
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
