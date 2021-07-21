import { Component, OnInit } from '@angular/core';
import {CompetenceService} from "../../../services/competenceService/competence.service";

@Component({
  selector: 'app-competence',
  templateUrl: './competence.component.html',
  styleUrls: ['./competence.component.css']
})
export class CompetenceComponent implements OnInit {

  constructor(private competenceService: CompetenceService) { }

  ngOnInit(): void {
  }

}
