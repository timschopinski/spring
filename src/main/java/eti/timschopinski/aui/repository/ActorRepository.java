package eti.timschopinski.aui.repository;

import eti.timschopinski.aui.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ActorRepository extends JpaRepository<Actor, UUID> {
    List<Actor> findByMovies_Title(String movieTitle);
}
