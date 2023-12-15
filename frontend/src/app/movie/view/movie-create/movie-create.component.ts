import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MovieService } from '../../service/movie.service';

@Component({
  selector: 'app-movie-create',
  templateUrl: 'movie-create.component.html',
  styleUrls: ['movie-create.component.css']
})
export class MovieCreateComponent {
  movieTitle: string = '';
  movieReleaseYear: number = 0;
  directorId: string | null = null;

  constructor(private route: ActivatedRoute, private router: Router, private movieService: MovieService) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.directorId = params.get('id');
    });
  }

  onSubmit(): void {
    const newMovie = {
      title: this.movieTitle,
      releaseYear: this.movieReleaseYear,
      directorId: this.directorId
    };

    this.movieService.createMovie(newMovie).subscribe(() => {
      this.router.navigate(['/movie']);
    });
  }
}
