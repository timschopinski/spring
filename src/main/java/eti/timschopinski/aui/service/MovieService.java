package eti.timschopinski.aui.service;
import eti.timschopinski.aui.Movie;
import eti.timschopinski.aui.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(UUID id) {
        return movieRepository.findById(id);
    }

    public List<Movie> getMoviesByDirectorName(String directorName) {
        return movieRepository.findByDirectorName(directorName);
    }

}
