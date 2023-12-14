package eti.timschopinski.directorapp.function;

import eti.timschopinski.directorapp.Director;
import eti.timschopinski.directorapp.dto.GetDirectorResponse;
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
