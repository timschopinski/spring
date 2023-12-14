package eti.timschopinski.movieapp.repository;

import eti.timschopinski.movieapp.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DirectorRepository extends JpaRepository<Director, UUID> {

}
