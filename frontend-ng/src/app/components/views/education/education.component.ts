import { Component, OnInit } from '@angular/core';
import {EducationService} from "../../../services/educationService/education.service";

@Component({
  selector: 'app-education',
  templateUrl: './education.component.html',
  styleUrls: ['./education.component.css']
})
export class EducationComponent implements OnInit {

  constructor(private eduService: EducationService) { }

  ngOnInit(): void {
  }

}
