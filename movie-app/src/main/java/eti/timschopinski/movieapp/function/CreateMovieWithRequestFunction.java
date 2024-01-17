package eti.timschopinski.movieapp.function;

import eti.timschopinski.movieapp.Movie;
import eti.timschopinski.movieapp.Director;
import eti.timschopinski.movieapp.dto.CreateMovieRequest;
import eti.timschopinski.movieapp.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Function;

@Component
public class CreateMovieWithRequestFunction implements Function<CreateMovieRequest, Movie> {

    private final DirectorService directorService;

    @Autowired
    public CreateMovieWithRequestFunction(DirectorService directorService) {
        this.directorService = directorService;
    }

    @Override
    public Movie apply(CreateMovieRequest request) {
        Director director = directorService.find(request.getDirectorId())
                .orElseThrow(() -> new RuntimeException("Director not found for UUID: " + request.getDirectorId()));

        return Movie.builder()
                .id(UUID.randomUUID())
                .title(request.getTitle())
                .releaseYear(request.getReleaseYear())
                .director(director)
                .build();
    }
}
