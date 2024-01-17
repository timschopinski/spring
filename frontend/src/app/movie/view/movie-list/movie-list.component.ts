import { Component, OnInit } from '@angular/core';
import { MovieService } from "../../service/movie.service";
import { Movies } from "../../model/movies";
import { Movie } from "../../model/movie";

@Component({
  selector: 'app-movie-list',
  templateUrl: 'movie-list.component.html',
  styleUrls: ['movie-list.component.css']
})
export class MovieListComponent implements OnInit {

  /**
   * @param service movies service
   */
  constructor(private service: MovieService) {
  }

  /**
   * Available movies.
   */
  movies: Movies | undefined;

  ngOnInit(): void {
    this.service.getMovies().subscribe(movies => this.movies = movies);
  }

  /**
   * Deletes selected movie.
   *
   * @param movie movie to be removed
   */
  onDelete(movie: Movie): void {
    this.service.deleteMovie(movie.id).subscribe(() => this.ngOnInit());
  }

}
