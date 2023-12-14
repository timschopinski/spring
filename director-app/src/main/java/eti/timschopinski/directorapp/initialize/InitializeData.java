package eti.timschopinski.directorapp.initialize;
import eti.timschopinski.directorapp.Director;
import eti.timschopinski.directorapp.service.DirectorService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {

    private final DirectorService directorService;

    @Autowired
    public InitializeData(DirectorService directorService) {
        this.directorService = directorService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        if (directorService.findAll().isEmpty()) {

            Director director1 = Director.builder()
                    .id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d4"))
                    .name("John Carpenter")
                    .age(75)
                    .build();
            Director director2 = Director.builder()
                    .id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d3"))
                    .name("Martin Scorsese")
                    .age(80)
                    .build();

            Director director3 = Director.builder()
                    .id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d2"))
                    .name("Ridley Scott")
                    .age(85)
                    .build();

            directorService.create(director1);
            directorService.create(director2);
            directorService.create(director3);

        }
    }
}

