import { Component, OnInit } from '@angular/core';
import {Title} from "@angular/platform-browser";
import {AuthService} from "../../services/authService/auth.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private title: Title,
              public authService: AuthService) { }

  ngOnInit(): void {
  }

  setTitle(title: string): void{
    this.title.setTitle( title + " - Majesty" )
  }
}
