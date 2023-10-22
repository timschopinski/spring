package eti.timschopinski.aui.controller;

import eti.timschopinski.aui.dto.PutMovieRequest;
import eti.timschopinski.aui.function.UpdateMovieWithRequestFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import eti.timschopinski.aui.dto.GetMovieResponse;
import eti.timschopinski.aui.dto.GetMoviesResponse;
//import eti.timschopinski.aui.dto.PutMovieRequest;
import eti.timschopinski.aui.Movie;
import eti.timschopinski.aui.function.MovieToResponseFunction;
import eti.timschopinski.aui.function.MoviesToResponseFunction;
//import eti.timschopinski.aui.function.RequestToMovieFunction;
import eti.timschopinski.aui.service.MovieService;

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