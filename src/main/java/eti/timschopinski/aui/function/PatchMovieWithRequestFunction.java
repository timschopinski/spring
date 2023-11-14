package eti.timschopinski.aui.function;

import eti.timschopinski.aui.Director;
import eti.timschopinski.aui.Movie;
import eti.timschopinski.aui.dto.PatchMovieRequest;
import eti.timschopinski.aui.service.DirectorService;
import eti.timschopinski.aui.service.MovieService;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class PatchMovieWithRequestFunction implements BiFunction<UUID, PatchMovieRequest, Movie> {
    private final MovieService movieService;
    private final DirectorService directorService;

    public PatchMovieWithRequestFunction(MovieService movieService, DirectorService directorService) {
        this.movieService = movieService;
        this.directorService = directorService;
    }

    @Override
    public Movie apply(UUID id, PatchMovieRequest request) {

        Optional<Movie> optionalExistingMovie = movieService.find(id);
        Movie existingMovie = optionalExistingMovie.orElseThrow(() ->
                new RuntimeException("Movie not found for ID: " + id)
        );

        if (request.getTitle() != null) {
            existingMovie.setTitle(request.getTitle());
        }
        if (request.getReleaseYear() != null) {
            existingMovie.setReleaseYear(request.getReleaseYear());
        }
        if (request.getDirector() != null) {
            Optional<Director> optionalExistingDirector = directorService.find(request.getDirector());

            Director existingDirector = optionalExistingDirector.orElseThrow(() ->
                    new RuntimeException("Director not found for ID: " + request.getDirector())
            );

            existingMovie.setDirector(existingDirector);
        }
        return existingMovie;
    }
}
