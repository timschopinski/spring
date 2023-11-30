package eti.timschopinski.movieapp.controller;
import eti.timschopinski.movieapp.Director;
import eti.timschopinski.movieapp.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/api/directors")
public class DirectorController {

    private final DirectorService service;

    @Autowired
    public DirectorController(
            DirectorService service

    ) {
        this.service = service;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDirector(@PathVariable UUID id) {
        Optional<Director> existingDirector = service.find(id);

        if (existingDirector.isPresent()) {
            service.delete(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Director with ID " + id + " not found");
        }
    }

}
