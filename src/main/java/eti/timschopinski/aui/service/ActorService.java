package eti.timschopinski.aui.service;

import eti.timschopinski.aui.Actor;
import eti.timschopinski.aui.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ActorService {
    private final ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    public Actor getActorById(UUID id) {
        return actorRepository.findById(id).orElse(null);
    }

    public List<Actor> getActorsByMovieTitle(String movieTitle) {
        return actorRepository.findByMovies_Title(movieTitle);
    }

    // Add more service methods as needed
}
