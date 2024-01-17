// director-list.component.ts
import { Component, OnInit } from '@angular/core';
import {DirectorService} from "../../service/director.service";
import {Director} from "../../model/director";
import {Directors} from "../../model/directors";



@Component({
  selector: 'app-director-list',
  templateUrl: 'director-list.component.html',
  styleUrls: ['director-list.component.css'],
})
export class DirectorListComponent implements OnInit {
  directors: Directors | undefined;

  constructor(private directorService: DirectorService) {}

  ngOnInit(): void {
    this.directorService.getDirectors().subscribe((directors) => {
      this.directors = directors;
    });
  }
}
