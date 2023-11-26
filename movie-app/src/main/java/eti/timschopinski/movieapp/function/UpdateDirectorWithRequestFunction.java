package eti.timschopinski.movieapp.function;

import eti.timschopinski.movieapp.Director;
import eti.timschopinski.movieapp.dto.PutDirectorRequest;
import org.springframework.stereotype.Component;
import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class UpdateDirectorWithRequestFunction implements BiFunction<UUID, PutDirectorRequest, Director> {

    @Override
    public Director apply(UUID id, PutDirectorRequest request) {
        return Director.builder()
                .id(id)
                .name(request.getName())
                .age(request.getAge())
                .build();
    }
}
