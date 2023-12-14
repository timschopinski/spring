package eti.timschopinski.directorapp.event.rest;

import eti.timschopinski.directorapp.event.api.DirectorEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class DirectorEventRestRepository implements DirectorEventRepository {

    private final RestTemplate restTemplate;

    public DirectorEventRestRepository(RestTemplate template) {
        this.restTemplate = template;
    }

    @Override
    public void delete(UUID id) {
        restTemplate.delete("/api/directors/{id}", id);
    }

}
