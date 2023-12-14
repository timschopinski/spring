import { Component, OnInit } from '@angular/core';
import { MovieService } from '../../service/movie.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Movie } from '../../model/movie';


@Component({
  selector: 'app-movie-detail',
  templateUrl: './movie-detail.component.html',
  styleUrls: ['./movie-detail.component.css'],
})
export class MovieDetailComponent implements OnInit {

  movie: Movie | undefined;

  constructor(
    private service: MovieService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.route.params.subscribe((params) => {
      this.service.getMovie(params['id']).subscribe((movie) => {
        this.movie = movie;
      });
    });
  }
  goBack(): void {
    this.router.navigate(['/movies']);
  }
}
