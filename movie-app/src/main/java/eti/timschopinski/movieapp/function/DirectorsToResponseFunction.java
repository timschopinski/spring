package eti.timschopinski.movieapp.function;


import eti.timschopinski.movieapp.Director;
import eti.timschopinski.movieapp.dto.GetDirectorsResponse;
import org.springframework.stereotype.Component;

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
