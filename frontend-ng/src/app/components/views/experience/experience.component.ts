import { Component, OnInit } from '@angular/core';
import {ExperienceService} from "../../../services/experienceService/experience.service";

@Component({
  selector: 'app-experience',
  templateUrl: './experience.component.html',
  styleUrls: ['./experience.component.scss']
})
export class ExperienceComponent implements OnInit {

  constructor(private expService: ExperienceService) { }

  ngOnInit(): void {
  }

}
