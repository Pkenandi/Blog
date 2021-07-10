import { Component, OnInit } from '@angular/core';
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-wrapper',
  templateUrl: './wrapper.component.html',
  styleUrls: ['./wrapper.component.scss']
})
export class WrapperComponent implements OnInit {

  isExpended: boolean = false;

  constructor(private title: Title) { }

  ngOnInit(): void {
  }

  setTitle(title: string): void{
    this.title.setTitle(title + " - Majesty Blog")
  }
}
