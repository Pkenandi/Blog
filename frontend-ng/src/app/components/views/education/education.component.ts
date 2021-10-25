import {Component, OnInit} from '@angular/core';
import {EducationService} from "../../../services/educationService/education.service";
import {Education} from "../../../models/Education/education";
import {HttpErrorResponse} from "@angular/common/http";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-education',
  templateUrl: './education.component.html',
  styleUrls: ['./education.component.scss']
})
export class EducationComponent implements OnInit {

  educations: Education[] = [];
  educationItem: Education;

  constructor(private eduService: EducationService, private modal: NgbModal) {
  }

  ngOnInit(): void {
    this.getEducations();
  }

  getEducations(): void {
    this.eduService.getEducations()
      .subscribe((educations) => {
        this.educations = educations;
      },
        (error: HttpErrorResponse) => {
        console.log(' Error education ', error);
        })
  }

  getOne(id: number): void {
    this.eduService.getOne(id)
      .subscribe((education) => {
        this.educationItem = education;
      });
  }

  openModal(education, id: number){
    this.getOne(id);
    this.modal.open(education, {"centered": true,"size":"lg"})
  }

}
