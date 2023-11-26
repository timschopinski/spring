package eti.timschopinski.aui.function;

import eti.timschopinski.aui.Director;
import eti.timschopinski.aui.dto.CreateDirectorRequest;
import eti.timschopinski.aui.service.DirectorService;
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
