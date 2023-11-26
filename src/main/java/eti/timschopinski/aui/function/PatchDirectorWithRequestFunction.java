package eti.timschopinski.aui.function;

import eti.timschopinski.aui.Director;
import eti.timschopinski.aui.dto.PatchDirectorRequest;
import eti.timschopinski.aui.service.DirectorService;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class PatchDirectorWithRequestFunction implements BiFunction<UUID, PatchDirectorRequest, Director> {
    private final DirectorService directorService;

    public PatchDirectorWithRequestFunction(DirectorService directorService) {
        this.directorService = directorService;
    }

    @Override
    public Director apply(UUID id, PatchDirectorRequest request) {
        Optional<Director> optionalExistingDirector = directorService.find(id);

        Director existingDirector = optionalExistingDirector.orElseThrow(() ->
                new RuntimeException("Director not found for ID: " + id)
        );

        if (request.getName() != null) {
            existingDirector.setName(request.getName());
        }
        if (request.getAge() != null) {
            existingDirector.setAge(request.getAge());
        }

        return existingDirector;
    }
}
