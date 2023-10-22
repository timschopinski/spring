package eti.timschopinski.aui.service;

import eti.timschopinski.aui.Director;
import eti.timschopinski.aui.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DirectorService {
    private final DirectorRepository directorRepository;

    @Autowired
    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public List<Director> getAllDirectors() {
        return directorRepository.findAll();
    }

    public Optional<Director> getDirectorById(UUID id) {
        return directorRepository.findById(id);
    }

    public void create(Director director) {
        directorRepository.save(director);
    }

}
