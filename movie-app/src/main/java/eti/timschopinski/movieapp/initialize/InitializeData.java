package eti.timschopinski.movieapp.initialize;
import eti.timschopinski.movieapp.Director;
import eti.timschopinski.movieapp.Movie;
import eti.timschopinski.movieapp.service.DirectorService;
import eti.timschopinski.movieapp.service.MovieService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {

    private final DirectorService directorService;
    private final MovieService movieService;

    @Autowired
    public InitializeData(DirectorService directorService, MovieService movieService) {
        this.directorService = directorService;
        this.movieService = movieService;
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

            Movie movie1 = Movie.builder()
                    .id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d5"))
                    .title("The Wolf of Wallstreet")
                    .releaseYear(2012)
                    .director(director2)
                    .build();
            Movie movie2 = Movie.builder()
                    .id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d6"))
                    .title("The Thing")
                    .releaseYear(1982)
                    .director(director1)
                    .build();
            Movie movie3 = Movie.builder()
                    .id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d7"))
                    .title("Halloween")
                    .releaseYear(1978)
                    .director(director1)
                    .build();

            Movie movie4 = Movie.builder()
                    .id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d8"))
                    .title("Christine")
                    .releaseYear(1983)
                    .director(director1)
                    .build();

            Movie movie5 = Movie.builder()
                    .id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d9"))
                    .title("Killers of the Flower Moon")
                    .releaseYear(2023)
                    .director(director2)
                    .build();

            Movie movie6 = Movie.builder()
                    .id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d11786711810"))
                    .title("Shutter Island")
                    .releaseYear(2010)
                    .director(director2)
                    .build();

            Movie movie7 = Movie.builder()
                    .id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d11786711811"))
                    .title("Hannibal")
                    .releaseYear(2001)
                    .director(director3)
                    .build();

            Movie movie8 = Movie.builder()
                    .id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d11786711812"))
                    .title("Gladiator")
                    .releaseYear(2000)
                    .director(director3)
                    .build();

            Movie movie9 = Movie.builder()
                    .id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d11786711813"))
                    .title("Alien")
                    .releaseYear(1979)
                    .director(director3)
                    .build();

            movieService.create(movie1);
            movieService.create(movie2);
            movieService.create(movie3);
            movieService.create(movie4);
            movieService.create(movie5);
            movieService.create(movie6);
            movieService.create(movie7);
            movieService.create(movie8);
            movieService.create(movie9);
        }
    }
}

