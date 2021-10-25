import { Component, OnInit } from '@angular/core';
import {ProjetService} from "../../../services/projetService/projet.service";
import {Projet} from "../../../models/Projet/projet";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-projet',
  templateUrl: './projet.component.html',
  styleUrls: ['./projet.component.css']
})
export class ProjetComponent implements OnInit {

  projets: Projet[] = [];

  constructor(private projetService: ProjetService,
              private modal: NgbModal) { }

  ngOnInit(): void {
    this.getProjets();
  }

  private getProjets() {
    this.projetService.getProjects()
      .subscribe((projects) => {
        this.projets = projects;
      }, error => {
        console.log(" Erreur" + error);
      })
  }

  openDetails(detail) {
    this.modal.open(detail, {size: "lg", centered: true});
  }
}
