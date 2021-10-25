import { Component, OnInit } from '@angular/core';
import {EducationService} from "../../../../services/educationService/education.service";
import {AdminService} from "../../../../services/adminService/admin.service";
import {FormControl, FormGroup} from "@angular/forms";
import {Education} from "../../../../models/Education/education";

@Component({
  selector: 'app-add-education',
  templateUrl: './add-education.component.html',
  styleUrls: ['./add-education.component.css']
})
export class AddEducationComponent implements OnInit {

  eduForm = new FormGroup({
    etablissement: new FormControl(''),
    degree: new FormControl(''),
    average: new FormControl(''),
    start: new FormControl(''),
    expected_end: new FormControl(''),
    current: new FormControl(false),
  })

  education: Education;
  educations: Education[] = [];
  current = true;

  constructor(private eduService: EducationService,
              private adminService: AdminService) { }

  ngOnInit(): void {
    this.getEducations();
  }

  addEducation(): void {
    this.education = this.eduForm.value;
    console.log(" Data before : ", this.education);
    this.eduService.addEducation(this.education)
      .subscribe(
        (education) => {
          console.log(" Data after : ", education);
          // this.adminService.setEducation("Prince",education.id)
          //   .subscribe(
          //     () => {
          //       this.getEducations();
          //     },
          //     () => {
          //       console.warn(" --- Error --- ");
          //     }
          //   )
        }
      )
  }

  getEducations(): void{
    this.eduService.getEducations()
      .subscribe(
        (educations) => {
          this.educations = educations;
        }
      )
  }

}
