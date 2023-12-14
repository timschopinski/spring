package eti.timschopinski.movieapp.controller;

import eti.timschopinski.movieapp.dto.PutMovieRequest;
import eti.timschopinski.movieapp.function.UpdateMovieWithRequestFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import eti.timschopinski.movieapp.dto.GetMovieResponse;
import eti.timschopinski.movieapp.dto.GetMoviesResponse;
//import eti.timschopinski.aui.dto.PutMovieRequest;
import eti.timschopinski.movieapp.Movie;
import eti.timschopinski.movieapp.function.MovieToResponseFunction;
import eti.timschopinski.movieapp.function.MoviesToResponseFunction;
//import eti.timschopinski.aui.function.RequestToMovieFunction;
import eti.timschopinski.movieapp.service.MovieService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Controller
public class MovieCLIController {

    private final MovieService service;
    private final MovieToResponseFunction movieToResponse;
    private final MoviesToResponseFunction moviesToResponse;
    private final UpdateMovieWithRequestFunction updateMovieWithRequest;

    @Autowired
    public MovieCLIController(
            MovieService service,
            MovieToResponseFunction movieToResponse,
            MoviesToResponseFunction moviesToResponse,
            UpdateMovieWithRequestFunction updateMovieWithRequest
    ) {
        this.service = service;
        this.movieToResponse = movieToResponse;
        this.moviesToResponse = moviesToResponse;
        this.updateMovieWithRequest = updateMovieWithRequest;
    }

    public GetMoviesResponse getMovies() {
        List<Movie> allMovies = service.findAll();
        return moviesToResponse.apply(allMovies);
    }

    public GetMovieResponse getMovie(UUID id) {
        Movie movie = service.find(id).orElseThrow(NoSuchElementException::new);
        return movieToResponse.apply(movie);
    }

    public void putMovie(UUID id, PutMovieRequest request) {
        Movie movie = updateMovieWithRequest.apply(id, request);
        service.create(movie);
    }

    public void deleteMovie(UUID id) {
        service.delete(id);
    }
}