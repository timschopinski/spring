import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Movies } from "../model/movies";
import { MovieDetails } from "../model/movie-details";
import { MovieForm } from "../model/movie-form";
import {DirectorForm} from "../../director/model/director-form";

@Injectable()
export class MovieService {
  private readonly backendHost = 'http://localhost:8083';

  constructor(private http: HttpClient) {}

  getMovies(): Observable<Movies> {
    return this.http.get<Movies>(this.backendHost + '/api/movies');
  }

  getMovie(movieId: string): Observable<MovieDetails> {
    return this.http.get<MovieDetails>(this.backendHost + '/api/movies/' + movieId);
  }

  createMovie(request: MovieForm): Observable<any> {
    return this.http.post(this.backendHost + '/api/movies', request);
  }

  deleteMovie(movieId: string): Observable<any> {
    return this.http.delete(this.backendHost + '/api/movies/' + movieId);
  }

  putMovie(movieId: string, request: MovieForm): Observable<any> {
    return this.http.put(this.backendHost + '/api/movies/' + movieId, request);
  }

}
