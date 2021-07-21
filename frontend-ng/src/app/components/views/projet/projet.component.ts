import { Component, OnInit } from '@angular/core';
import {ProjetService} from "../../../services/projetService/projet.service";
import {Projet} from "../../../models/Projet/projet";

@Component({
  selector: 'app-projet',
  templateUrl: './projet.component.html',
  styleUrls: ['./projet.component.css']
})
export class ProjetComponent implements OnInit {

  projets: Projet[] = [];

  constructor(private projetService: ProjetService) { }

  ngOnInit(): void {
    this.getProjets();
  }

  private getProjets() {

  }
}
