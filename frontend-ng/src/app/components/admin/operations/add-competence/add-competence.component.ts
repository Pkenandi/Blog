import { Component, OnInit } from '@angular/core';
import {Competence} from "../../../../models/Competence/competence";
import {FormControl, FormGroup} from "@angular/forms";
import {CompetenceService} from "../../../../services/competenceService/competence.service";
import {AdminService} from "../../../../services/adminService/admin.service";

@Component({
  selector: 'app-add-competence',
  templateUrl: './add-competence.component.html',
  styleUrls: ['./add-competence.component.css']
})
export class AddCompetenceComponent implements OnInit {

  competence!:Competence;
  competences: Competence[] = [];
  competenceForm = new FormGroup({
    name: new FormControl(''),
    numberOfYear: new FormControl(''),
  })

  constructor(private competenceService: CompetenceService,
              private adminService: AdminService) { }

  ngOnInit(): void {
    this.getAll()
  }

  setCompetence(): void {
    this.competence = this.competenceForm.value;
    this.competenceService.setCompetence(this.competence)
      .subscribe(
        (competence) => {
          this.adminService.setCompetence("Prince",competence.id)
            .subscribe(
              (admin) => {
                console.log(admin);
                this.getAll();
              }
            )
        }
      )

  }

  getAll(): void {
    this.competenceService.getAll()
      .subscribe(
        (competences) => {
          this.competences = competences;
        }
      )
  }
}
