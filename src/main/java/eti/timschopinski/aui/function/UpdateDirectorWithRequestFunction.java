package eti.timschopinski.aui.function;

import eti.timschopinski.aui.Director;
import eti.timschopinski.aui.dto.PutDirectorRequest;
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
