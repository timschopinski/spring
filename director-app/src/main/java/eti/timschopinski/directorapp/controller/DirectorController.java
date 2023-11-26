package eti.timschopinski.directorapp.controller;

import eti.timschopinski.directorapp.Director;
import eti.timschopinski.directorapp.dto.*;
import eti.timschopinski.directorapp.function.*;
import eti.timschopinski.directorapp.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/api/directors")
public class DirectorController {

    private final DirectorService service;
    private final DirectorsToResponseFunction directorsToResponse;
    private final DirectorToResponseFunction directorToResponse;
    private final UpdateDirectorWithRequestFunction updateDirectorWithRequest;
    private final CreateDirectorWithRequestFunction createDirectorWithRequest;
    private final PatchDirectorWithRequestFunction patchDirectorWithRequest;

    @Autowired
    public DirectorController(
            DirectorService service,
            DirectorsToResponseFunction directorsToResponse,
            DirectorToResponseFunction directorToResponse,
            UpdateDirectorWithRequestFunction updateDirectorWithRequest,
            CreateDirectorWithRequestFunction createDirectorWithRequest,
            PatchDirectorWithRequestFunction patchDirectorWithRequest

    ) {
        this.service = service;
        this.directorsToResponse = directorsToResponse;
        this.directorToResponse = directorToResponse;
        this.updateDirectorWithRequest = updateDirectorWithRequest;
        this.createDirectorWithRequest = createDirectorWithRequest;
        this.patchDirectorWithRequest = patchDirectorWithRequest;
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public GetDirectorsResponse getDirectors() {
        List<Director> allDirectors = service.findAll();
        return directorsToResponse.apply(allDirectors);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetDirectorResponse getDirector(@PathVariable UUID id) {
        return service.find(id)
                .map(directorToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UUID createDirector(@RequestBody CreateDirectorRequest request) {
        Director newDirector = createDirectorWithRequest.apply(request);
        service.create(newDirector);
        return newDirector.getId();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void putDirector(@PathVariable UUID id, @RequestBody PutDirectorRequest request) {
        Optional<Director> existingDirector = service.find(id);

        if (existingDirector.isPresent()) {
            Director updatedDirector = updateDirectorWithRequest.apply(id, request);
            service.update(updatedDirector);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Director with ID " + id + " not found");
        }
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void patchDirector(@PathVariable UUID id, @RequestBody PatchDirectorRequest request) {
        Optional<Director> existingDirector = service.find(id);

        if (existingDirector.isPresent()) {
            Director updatedDirector = patchDirectorWithRequest.apply(id, request);
            service.update(updatedDirector);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Director with ID " + id + " not found");
        }
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDirector(@PathVariable UUID id) {
        service.find(id)
                .ifPresentOrElse(
                profession -> service.delete(id),
                () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
            );
    }


}
