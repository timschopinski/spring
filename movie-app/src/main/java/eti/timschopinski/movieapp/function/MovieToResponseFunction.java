package eti.timschopinski.movieapp.function;

import eti.timschopinski.movieapp.dto.GetMoviesResponse;
import org.springframework.stereotype.Component;
import eti.timschopinski.movieapp.dto.GetMovieResponse;
import eti.timschopinski.movieapp.Movie;

import java.util.function.Function;

@Component
public class MovieToResponseFunction implements Function<Movie, GetMovieResponse> {

    @Override
    public GetMovieResponse apply(Movie entity) {
        return GetMovieResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .releaseYear(entity.getReleaseYear())
                .build();
    }
}
