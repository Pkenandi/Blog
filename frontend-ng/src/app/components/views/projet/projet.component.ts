import { Component, OnInit } from '@angular/core';
import {ProjetService} from "../../../services/projetService/projet.service";
import {Projet} from "../../../models/Projet/projet";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {ToastrService} from "ngx-toastr";
import {HttpErrorResponse} from "@angular/common/http";
import {faFileMedicalAlt} from "@fortawesome/free-solid-svg-icons";

@Component({
  selector: 'app-projet',
  templateUrl: './projet.component.html',
  styleUrls: ['./projet.component.scss']
})
export class ProjetComponent implements OnInit {

  faFileMedicalAlt = faFileMedicalAlt;
  projets: Projet[] = [];
  project: Projet;

  constructor(private projetService: ProjetService,
              private modal: NgbModal,
              private toastService: ToastrService) { }

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

  private getProject(id: number): void {
    this.projetService.getProject(id)
      .subscribe(
        project => {
        this.project = project;
      }, (error : HttpErrorResponse) => {
          this.toastService.error("Project not found ", error.message)
        })
  }

  openDetails(detail, projectId) {
    this.modal.open(detail, {size: "lg", centered: true});
    this.getProject(projectId);
  }
}
