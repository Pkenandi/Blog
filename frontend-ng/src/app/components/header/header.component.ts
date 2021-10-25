import {Component, OnInit} from '@angular/core';
import {Title} from "@angular/platform-browser";
import {AuthService} from "../../services/authService/auth.service";
import {
  faHome, faUserCircle,
  faAward, faIndustry,
  faBook, faProjectDiagram
} from '@fortawesome/free-solid-svg-icons';
import * as $ from 'jquery';
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  /* Icons*/
  faHome = faHome;
  userIcon = faUserCircle;
  faAward = faAward;
  faIndustry = faIndustry;
  faBook = faBook;
  faProjectDiagram = faProjectDiagram;

  constructor(private title: Title,
              public authService: AuthService) {}

  ngOnInit(): void {
    this.onInit();
  }

  onInit() {
    let self = this;
    $(document).ready(function ($) {
      setTimeout(function () {
        self.setAnimation();
      })
    });

    $(window).on('resize', function () {
      setTimeout(function () {
        self.setAnimation();
      }, 500);
    });
    $(".navbar-toggler").on("click", function () {
      $(".navbar-collapse").slideToggle(300);
      setTimeout(function () {
        self.setAnimation();
      });
    });
  }

  setAnimation() {
    let tabsNewAnim = $('.navbar-nav');
    let activeItemNewAnim = tabsNewAnim.find('.active');
    let activeWidthNewAnimHeight = activeItemNewAnim.innerHeight();
    let activeWidthNewAnimWidth = activeItemNewAnim.innerWidth();
    let itemPosNewAnimTop = activeItemNewAnim.position();
    let itemPosNewAnimLeft = activeItemNewAnim.position();

    $(".hori-selector").css({
      "top": itemPosNewAnimTop.top + "px",
      "left": itemPosNewAnimLeft.left + "px",
      "height": activeWidthNewAnimHeight + "px",
      "width": activeWidthNewAnimWidth + "px"
    });

    $("#navbarSupportedContent").on("click", "li", function (e) {
      $('#navbarSupportedContent ul li a').removeClass("active");
      $(this).addClass('active');
      let activeWidthNewAnimHeight = $(this).innerHeight();
      let activeWidthNewAnimWidth = $(this).innerWidth();
      let itemPosNewAnimTop = $(this).position();
      let itemPosNewAnimLeft = $(this).position();

      $(".hori-selector").css({
        "top": itemPosNewAnimTop.top + "px",
        "left": itemPosNewAnimLeft.left + "px",
        "height": activeWidthNewAnimHeight + "px",
        "width": activeWidthNewAnimWidth + "px"
      });
    });
  }

  setTitle(title: string): void {
    this.title.setTitle(title + " - Majesty")
  }
}
