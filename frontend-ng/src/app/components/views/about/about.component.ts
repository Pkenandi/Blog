import { Component, OnInit } from '@angular/core';
import {LangueService} from "../../../services/langueService/langue.service";

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.scss']
})
export class AboutComponent implements OnInit {

  constructor(private langueService: LangueService) { }

  ngOnInit(): void {
  }

}
