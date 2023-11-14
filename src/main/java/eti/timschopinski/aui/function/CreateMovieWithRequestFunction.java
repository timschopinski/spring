package eti.timschopinski.aui.function;

import eti.timschopinski.aui.Movie;
import eti.timschopinski.aui.Director;
import eti.timschopinski.aui.dto.CreateMovieRequest;
import eti.timschopinski.aui.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        Director director = directorService.find(request.getDirector())
                .orElseThrow(() -> new RuntimeException("Director not found for UUID: " + request.getDirector()));

        return Movie.builder()
                .title(request.getTitle())
                .releaseYear(request.getReleaseYear())
                .director(director)
                .build();
    }
}
