import { Component, OnInit } from '@angular/core';
import {CompetenceService} from "../../../services/competenceService/competence.service";
import {Competence} from "../../../models/Competence/competence";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-competence',
  templateUrl: './competence.component.html',
  styleUrls: ['./competence.component.css']
})
export class CompetenceComponent implements OnInit {
  skill: Competence = null;
  skills: Competence[] = [];

  constructor(private competenceService: CompetenceService) { }

  ngOnInit(): void {
    this.getSkills();
  }

  getSkills(): void {
    this.competenceService.getAll()
      .subscribe(
        (skills) => {
          this.skills = skills;
        },
        (error: HttpErrorResponse) => {
          alert(" Error : " + error);
        }
      )
  }

}
