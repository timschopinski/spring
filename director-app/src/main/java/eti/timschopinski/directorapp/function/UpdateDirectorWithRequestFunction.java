package eti.timschopinski.directorapp.function;

import eti.timschopinski.directorapp.Director;
import eti.timschopinski.directorapp.dto.PutDirectorRequest;
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
