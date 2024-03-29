package eti.timschopinski.directorapp.function;

import eti.timschopinski.directorapp.Director;
import eti.timschopinski.directorapp.dto.CreateDirectorRequest;
import eti.timschopinski.directorapp.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Function;

@Component
public class CreateDirectorWithRequestFunction implements Function<CreateDirectorRequest, Director> {

    private final DirectorService directorService;

    @Autowired
    public CreateDirectorWithRequestFunction(DirectorService directorService) {
        this.directorService = directorService;
    }

    @Override
    public Director apply(CreateDirectorRequest request) {
        return Director.builder()
                .id(UUID.randomUUID())
                .name(request.getName())
                .age(request.getAge())
                .build();
    }
}
