package eti.timschopinski.aui.initialize;
import eti.timschopinski.aui.Director;
import eti.timschopinski.aui.Movie;
import eti.timschopinski.aui.service.DirectorService;
import eti.timschopinski.aui.service.MovieService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

            Movie movie1 = Movie.builder()
                    .title("The Wolf of Wallstreet")
                    .releaseYear(2012)
                    .director(director2)
                    .build();
            Movie movie2 = Movie.builder()
                    .title("The Thing")
                    .releaseYear(1982)
                    .director(director1)
                    .build();
            Movie movie3 = Movie.builder()
                    .title("Halloween")
                    .releaseYear(1978)
                    .director(director1)
                    .build();

            Movie movie4 = Movie.builder()
                    .title("Christine")
                    .releaseYear(1983)
                    .director(director1)
                    .build();

            Movie movie5 = Movie.builder()
                    .title("Killers of the Flower Moon")
                    .releaseYear(2023)
                    .director(director2)
                    .build();

            Movie movie6 = Movie.builder()
                    .title("Shutter Island")
                    .releaseYear(2010)
                    .director(director2)
                    .build();

            Movie movie7 = Movie.builder()
                    .title("Hannibal")
                    .releaseYear(2001)
                    .director(director3)
                    .build();

            Movie movie8 = Movie.builder()
                    .title("Gladiator")
                    .releaseYear(2000)
                    .director(director3)
                    .build();

            Movie movie9 = Movie.builder()
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
