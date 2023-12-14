import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {DirectorDetails} from "../../model/director-details";
import {DirectorService} from "../../service/director.service";

@Component({
  selector: 'app-director-detail',
  templateUrl: 'director-detail.component.html',
  styleUrls: ['director-detail.component.css'],
})
export class DirectorDetailComponent implements OnInit {
  director: DirectorDetails | undefined;

  constructor(
    private service: DirectorService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.route.params.subscribe((params) => {
      this.service.getDirector(params['id']).subscribe((director) => {
        this.director = director;
      });
    });
  }
  goBack(): void {
    this.router.navigate(['/directors']);
  }
}
