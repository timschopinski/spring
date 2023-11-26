package eti.timschopinski.movieapp.function;

import eti.timschopinski.movieapp.Director;
import eti.timschopinski.movieapp.dto.GetDirectorResponse;
import org.springframework.stereotype.Component;
import java.util.function.Function;

@Component
public class DirectorToResponseFunction implements Function<Director, GetDirectorResponse> {

    @Override
    public GetDirectorResponse apply(Director entity) {
        return GetDirectorResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .age(entity.getAge())
                .build();
    }
}
