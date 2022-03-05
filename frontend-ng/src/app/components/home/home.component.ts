import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  messages = ["Très empathique, facilement abordable et serviable",
            "Capable de travail seul ou en équipe",
            "Possedant une facilité à comminiqué avec mes co-workers",
            "Riche en patience et très ouvert d'ésprit",
            "Me considerant beaucoup plus comme un problem-solver qui utilise la programmation comme outil pour y arrivé",
            "Possedant comme arme principale 'la créativité'",
            "Capable de bien gérer mon temps et diviser mes tâches"]
  constructor() { }

  ngOnInit(): void {
  }
}
