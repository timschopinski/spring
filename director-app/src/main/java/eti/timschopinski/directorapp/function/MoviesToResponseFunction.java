package eti.timschopinski.directorapp.function;


import eti.timschopinski.directorapp.Movie;
import eti.timschopinski.directorapp.dto.GetMoviesResponse;
import org.springframework.stereotype.Component;

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
