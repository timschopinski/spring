package eti.timschopinski.directorapp.controller;

import eti.timschopinski.directorapp.Director;
import eti.timschopinski.directorapp.dto.GetDirectorsResponse;
import eti.timschopinski.directorapp.function.DirectorsToResponseFunction;
import eti.timschopinski.directorapp.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.List;


@Controller
public class DirectorCLIController {

    private final DirectorService service;
    private final DirectorsToResponseFunction directorsToResponse;


    @Autowired
    public DirectorCLIController(
            DirectorService service,
            DirectorsToResponseFunction directorsToResponse
    ) {
        this.service = service;
        this.directorsToResponse = directorsToResponse;
    }

    public GetDirectorsResponse getDirectors() {
        List<Director> allDirectors = service.findAll();
        return directorsToResponse.apply(allDirectors);
    }

}