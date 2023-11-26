package eti.timschopinski.movieapp.function;

import eti.timschopinski.movieapp.Director;
import eti.timschopinski.movieapp.dto.CreateDirectorRequest;
import eti.timschopinski.movieapp.service.DirectorService;
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
                .name(request.getName())
                .age(request.getAge())
                .build();
    }
}
