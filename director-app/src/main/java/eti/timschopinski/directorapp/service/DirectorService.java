package eti.timschopinski.directorapp.service;

import eti.timschopinski.directorapp.Director;
import eti.timschopinski.directorapp.event.api.DirectorEventRepository;
import eti.timschopinski.directorapp.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DirectorService {
    private final DirectorRepository repository;
    private final DirectorEventRepository eventRepository;

    @Autowired
    public DirectorService(DirectorRepository repository, DirectorEventRepository eventRepository) {
        this.repository = repository;
        this.eventRepository = eventRepository;
    }

    public List<Director> findAll() {
        return repository.findAll();
    }

    public Optional<Director> find(UUID id) {
        return repository.findById(id);
    }

    public void create(Director director) {
        repository.save(director);
    }
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
        eventRepository.delete(id);
        System.out.println("DONE");
    }

    public void update(Director updatedDirector) {
        repository.save(updatedDirector);
    }
}
