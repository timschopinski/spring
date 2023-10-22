package eti.timschopinski.aui.controller;

import eti.timschopinski.aui.Director;
import eti.timschopinski.aui.dto.GetDirectorsResponse;
import eti.timschopinski.aui.function.DirectorsToResponseFunction;
import eti.timschopinski.aui.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.List;


@Controller
public class DirectorController {

    private final DirectorService service;
    private final DirectorsToResponseFunction directorsToResponse;


    @Autowired
    public DirectorController(
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
