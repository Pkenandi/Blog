import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from './components/home/home.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import {MatTabsModule} from "@angular/material/tabs";
import { LoginComponent } from './components/admin/login/login.component';
import { RegisterComponent } from './components/admin/register/register.component';
import { AddProjetComponent } from './components/admin/operations/add-projet/add-projet.component';
import { AddCurriculumComponent } from './components/admin/operations/add-curriculum/add-curriculum.component';
import { AddCompetenceComponent } from './components/admin/operations/add-competence/add-competence.component';
import { AddExperienceComponent } from './components/admin/operations/add-experience/add-experience.component';
import { AddEducationComponent } from './components/admin/operations/add-education/add-education.component';
import {MatSidenavModule} from "@angular/material/sidenav";
import { DashboardComponent } from './components/admin/dashboard/dashboard.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatIconModule} from "@angular/material/icon";
import { CompetenceComponent } from './components/views/competence/competence.component';
import { ExperienceComponent } from './components/views/experience/experience.component';
import { CurriculumComponent } from './components/views/curriculum/curriculum.component';
import { ProjetComponent } from './components/views/projet/projet.component';
import { ContactComponent } from './components/views/contact/contact.component';
import { AboutComponent } from './components/views/about/about.component';
import { AddAboutComponent } from './components/admin/operations/add-about/add-about.component';
import { EducationComponent } from './components/views/education/education.component';
import { WrapperComponent } from './components/admin/wrapper/wrapper.component';
import { AddContactComponent } from './components/admin/operations/add-contact/add-contact.component';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatListModule} from "@angular/material/list";
import {HttpClientModule} from "@angular/common/http";
import { AddProfileComponent } from './components/admin/operations/add-profile/add-profile.component';
import { AddInterestComponent } from './components/admin/operations/add-interest/add-interest.component';
import { InterestComponent } from './components/views/interest/interest.component';
import { ProfileComponent } from './components/views/profile/profile.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    RegisterComponent,
    AddProjetComponent,
    AddCurriculumComponent,
    AddCompetenceComponent,
    AddExperienceComponent,
    AddEducationComponent,
    DashboardComponent,
    CompetenceComponent,
    ExperienceComponent,
    CurriculumComponent,
    ProjetComponent,
    ContactComponent,
    AboutComponent,
    AddAboutComponent,
    EducationComponent,
    WrapperComponent,
    AddContactComponent,
    AddProfileComponent,
    AddInterestComponent,
    InterestComponent,
    ProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatTabsModule,
    MatSidenavModule,
    ReactiveFormsModule,
    FormsModule,
    MatIconModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
