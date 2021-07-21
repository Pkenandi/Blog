import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./components/home/home.component";
import {LoginComponent} from "./components/admin/login/login.component";
import {RegisterComponent} from "./components/admin/register/register.component";
import {DashboardComponent} from "./components/admin/dashboard/dashboard.component";
import {ContactComponent} from "./components/views/contact/contact.component";
import {CompetenceComponent} from "./components/views/competence/competence.component";
import {ExperienceComponent} from "./components/views/experience/experience.component";
import {ProjetComponent} from "./components/views/projet/projet.component";
import {CurriculumComponent} from "./components/views/curriculum/curriculum.component";
import {EducationComponent} from "./components/views/education/education.component";
import {WrapperComponent} from "./components/admin/wrapper/wrapper.component";
import {AddCompetenceComponent} from "./components/admin/operations/add-competence/add-competence.component";
import {AddCurriculumComponent} from "./components/admin/operations/add-curriculum/add-curriculum.component";
import {AddProjetComponent} from "./components/admin/operations/add-projet/add-projet.component";
import {AddContactComponent} from "./components/admin/operations/add-contact/add-contact.component";
import {AddEducationComponent} from "./components/admin/operations/add-education/add-education.component";
import {AddExperienceComponent} from "./components/admin/operations/add-experience/add-experience.component";
import {AddProfileComponent} from "./components/admin/operations/add-profile/add-profile.component";
import {AddInterestComponent} from "./components/admin/operations/add-interest/add-interest.component";
import {ProfileComponent} from "./components/views/profile/profile.component";
import {AddAboutComponent} from "./components/admin/operations/add-about/add-about.component";

const routes: Routes = [
  {path: "home", component: HomeComponent},

            /* Admin */
  {path: "admin/login", component: LoginComponent},
  {path: "admin/register", component: RegisterComponent},
  {
    path: "admin",
    component: WrapperComponent,
    children: [
      {
        path: 'dashboard',
        component: DashboardComponent
      },
      {
        path: 'add-skills',
        component: AddCompetenceComponent
      },
      {
        path: 'add-curriculum',
        component: AddAboutComponent
      },
      {
        path: 'add-realisation',
        component: AddProjetComponent
      },
      {
        path: 'add-skills',
        component: AddCompetenceComponent
      },
      {
        path: 'add-contact',
        component: AddContactComponent
      },
      {
        path: 'add-education',
        component: AddEducationComponent
      },
      {
        path: 'add-experience',
        component: AddExperienceComponent
      },
      {
        path: 'add-profile',
        component: AddProfileComponent
      },
      {
        path: 'add-interest',
        component: AddInterestComponent
      }
    ]
  },

            /* Others */

  {path: "contact", component: ContactComponent},
  {path: "skills", component: CompetenceComponent},
  {path: "experiences", component: ExperienceComponent},
  {path: "realisations", component: ProjetComponent},
  {path: "curriculum", component: CurriculumComponent},
  {path: "education", component: EducationComponent},
  {path: "profile", component: ProfileComponent},

            /* Redirecting */
  {path: "**", redirectTo: "home", pathMatch: "full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
