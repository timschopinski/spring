package eti.timschopinski.movieapp.repository;

import eti.timschopinski.movieapp.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MovieRepository extends JpaRepository<Movie, UUID> {
    List<Movie> findByDirectorName(String directorName);
}
