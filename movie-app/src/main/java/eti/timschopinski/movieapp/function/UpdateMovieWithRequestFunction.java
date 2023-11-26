package eti.timschopinski.movieapp.function;


import eti.timschopinski.movieapp.Movie;
import eti.timschopinski.movieapp.dto.PutMovieRequest;
import org.springframework.stereotype.Component;
import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class UpdateMovieWithRequestFunction implements BiFunction<UUID, PutMovieRequest, Movie> {

    @Override
    public Movie apply(UUID id, PutMovieRequest request) {
        return Movie.builder()
                .id(id)
                .title(request.getTitle())
                .releaseYear(request.getReleaseYear())
                .build();
    }

}
