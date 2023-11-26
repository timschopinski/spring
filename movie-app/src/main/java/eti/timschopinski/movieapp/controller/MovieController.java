package eti.timschopinski.movieapp.controller;

import eti.timschopinski.movieapp.dto.*;
import eti.timschopinski.movieapp.function.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import eti.timschopinski.aui.dto.PutMovieRequest;
import eti.timschopinski.movieapp.Movie;
//import eti.timschopinski.aui.function.RequestToMovieFunction;
import eti.timschopinski.movieapp.service.MovieService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.Console;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService service;
    private final MovieToResponseFunction movieToResponse;
    private final MoviesToResponseFunction moviesToResponse;
    private final UpdateMovieWithRequestFunction updateMovieWithRequest;
    private final CreateMovieWithRequestFunction createMovieWithRequest;
    private final PatchMovieWithRequestFunction patchMovieWithRequest;

    @Autowired
    public MovieController(
            MovieService service,
            MovieToResponseFunction movieToResponse,
            MoviesToResponseFunction moviesToResponse,
            UpdateMovieWithRequestFunction updateMovieWithRequest,
            CreateMovieWithRequestFunction createMovieWithRequest,
            PatchMovieWithRequestFunction patchMovieWithRequest
    ) {
        this.service = service;
        this.movieToResponse = movieToResponse;
        this.moviesToResponse = moviesToResponse;
        this.updateMovieWithRequest = updateMovieWithRequest;
        this.createMovieWithRequest = createMovieWithRequest;
        this.patchMovieWithRequest = patchMovieWithRequest;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    @ResponseBody
    public GetMoviesResponse getDirectors() {
        List<Movie> allMovies = service.findAll();
        return moviesToResponse.apply(allMovies);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GetMovieResponse GetMovieResponse(@PathVariable UUID id) {
        return service.find(id)
                .map(movieToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void putMovie(@PathVariable UUID id, @RequestBody PutMovieRequest request) {
        Optional<Movie> existingMovie = service.find(id);

        if (existingMovie.isPresent()) {
            Movie updatedMovie = updateMovieWithRequest.apply(id, request);
            service.update(updatedMovie);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Director with ID " + id + " not found");
        }
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void patchMovie(@PathVariable UUID id, @RequestBody PatchMovieRequest request) {
        Optional<Movie> existingMovie = service.find(id);

        if (existingMovie.isPresent()) {
            Movie updatedMovie = patchMovieWithRequest.apply(id, request);
            service.update(updatedMovie);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie with ID " + id + " not found");
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createMovie(@RequestBody CreateMovieRequest request) {
        Movie newMovie = createMovieWithRequest.apply(request);
        service.create(newMovie);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        profession -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }


}
