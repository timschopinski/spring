package eti.timschopinski.directorapp.service;
import eti.timschopinski.directorapp.Movie;
import eti.timschopinski.directorapp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MovieService {
    private final MovieRepository repository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.repository = movieRepository;
    }

    public List<Movie> findAll() {
        return repository.findAll();
    }

    public Optional<Movie> find(UUID id) {
        return repository.findById(id);
    }

    public void create(Movie movie) {
        repository.save(movie);
    }

    public void update(Movie movie) {
        repository.save(movie);
    }

    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    public List<Movie> getMoviesByDirectorName(String directorName) {
        return repository.findByDirectorName(directorName);
    }

}
