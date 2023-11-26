package eti.timschopinski.directorapp.initialize;
import eti.timschopinski.directorapp.Director;
import eti.timschopinski.directorapp.service.DirectorService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
                    .name("John Carpenter")
                    .age(75)
                    .build();
            Director director2 = Director.builder()
                    .name("Martin Scorsese")
                    .age(80)
                    .build();

            Director director3 = Director.builder()
                    .name("Ridley Scott")
                    .age(85)
                    .build();

            directorService.create(director1);
            directorService.create(director2);
            directorService.create(director3);

        }
    }
}

