package eti.timschopinski.aui.function;


import eti.timschopinski.aui.Director;
import eti.timschopinski.aui.dto.GetDirectorsResponse;
import org.springframework.stereotype.Component;
import eti.timschopinski.aui.dto.GetMoviesResponse;
import eti.timschopinski.aui.Movie;

import java.util.List;
import java.util.function.Function;


@Component
public class DirectorsToResponseFunction implements Function<List<Director>, GetDirectorsResponse> {

    @Override
    public GetDirectorsResponse apply(List<Director> entities) {
        return GetDirectorsResponse.builder()
                .directors(entities.stream()
                        .map(movie -> GetDirectorsResponse.Director.builder()
                                .id(movie.getId())
                                .name(movie.getName())
                                .age(movie.getAge())
                                .build())
                        .toList())
                .build();
    }

}
