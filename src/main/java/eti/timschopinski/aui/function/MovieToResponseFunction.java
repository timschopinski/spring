package eti.timschopinski.aui.function;

import eti.timschopinski.aui.dto.GetMoviesResponse;
import org.springframework.stereotype.Component;
import eti.timschopinski.aui.dto.GetMovieResponse;
import eti.timschopinski.aui.Movie;

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
