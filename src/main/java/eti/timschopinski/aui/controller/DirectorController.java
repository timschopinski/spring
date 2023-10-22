package eti.timschopinski.aui.controller;

import eti.timschopinski.aui.Director;
import eti.timschopinski.aui.dto.GetDirectorResponse;
import eti.timschopinski.aui.dto.GetDirectorsResponse;
import eti.timschopinski.aui.dto.PutDirectorRequest;
import eti.timschopinski.aui.function.DirectorToResponseFunction;
import eti.timschopinski.aui.function.DirectorsToResponseFunction;
import eti.timschopinski.aui.function.UpdateDirectorWithRequestFunction;
import eti.timschopinski.aui.service.DirectorService;
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

    @Autowired
    public DirectorController(
            DirectorService service,
            DirectorsToResponseFunction directorsToResponse,
            DirectorToResponseFunction directorToResponse,
            UpdateDirectorWithRequestFunction updateDirectorWithRequest
    ) {
        this.service = service;
        this.directorsToResponse = directorsToResponse;
        this.directorToResponse = directorToResponse;
        this.updateDirectorWithRequest = updateDirectorWithRequest;
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
