import { Component, OnInit } from '@angular/core';
import {InterestService} from "../../../services/interestService/interest.service";
import {Interest} from "../../../models/Interest/interest";

@Component({
  selector: 'app-interest',
  templateUrl: './interest.component.html',
  styleUrls: ['./interest.component.scss']
})
export class InterestComponent implements OnInit {

  interet: Interest[] = [];

  constructor(private interestService: InterestService) { }

  ngOnInit(): void {
  }

}
