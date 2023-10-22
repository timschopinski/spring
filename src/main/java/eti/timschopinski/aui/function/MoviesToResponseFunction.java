package eti.timschopinski.aui.function;


import eti.timschopinski.aui.dto.GetMovieResponse;
import org.springframework.stereotype.Component;
import eti.timschopinski.aui.dto.GetMoviesResponse;
import eti.timschopinski.aui.Movie;

import java.util.List;
import java.util.function.Function;


@Component
public class MoviesToResponseFunction implements Function<List<Movie>, GetMoviesResponse> {

    @Override
    public GetMoviesResponse apply(List<Movie> entities) {
        return GetMoviesResponse.builder()
                .movies(entities.stream()
                        .map(movie -> GetMoviesResponse.Movie.builder()
                                .id(movie.getId())
                                .title(movie.getTitle())
                                .releaseYear(movie.getReleaseYear())
                                .build())
                        .toList())
                .build();
    }

}
