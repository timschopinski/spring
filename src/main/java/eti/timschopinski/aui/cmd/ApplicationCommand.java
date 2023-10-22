package eti.timschopinski.aui.cmd;

import eti.timschopinski.aui.controller.DirectorController;
import eti.timschopinski.aui.dto.PutMovieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import eti.timschopinski.aui.controller.MovieController;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.UUID;

@Component
public class ApplicationCommand implements CommandLineRunner {

    private final MovieController movieController;
    private final DirectorController directorController;


    @Autowired
    public ApplicationCommand(MovieController movieController, DirectorController directorController) {
        this.movieController = movieController;
        this.directorController =directorController;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String command;
        mainLoop:
        while (true) {
            command = scanner.next();
            switch (command) {
                case "help" -> {
                    System.out.println("Available commands:");
                    System.out.println("1. get_movie <movieId>");
                    System.out.println("2. get_movies");
                    System.out.println("3. get_directors");
                    System.out.println("4. delete_movie");
                    System.out.println("5. create_movie");
                    System.out.println("6. quit");
                }
                case "get_movie" -> {
                    UUID movieId = UUID.fromString(scanner.next());
                    try {
                        System.out.println(movieController.getMovie(movieId));
                    } catch (NoSuchElementException ex) {
                        System.out.println("NOT_FOUND");
                    }
                }
                case "get_movies" -> System.out.println(movieController.getMovies());
                case "get_directors" -> System.out.println(directorController.getDirectors());
                case "delete_movie" -> {
                    UUID movieId = UUID.fromString(scanner.next());
                    try {
                        movieController.deleteMovie(movieId);
                        System.out.println("Movie with ID " + movieId + " deleted successfully.");
                    } catch (NoSuchElementException ex) {
                        System.out.println("NOT_FOUND");
                    }
                }

                case "create_movie" -> {
                    scanner.nextLine();
                    System.out.print("Enter the movie title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter the release year: ");
                    int releaseYear = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter the director's UUID: ");
                    UUID directorId = UUID.fromString(scanner.nextLine());


                    try {
                    PutMovieRequest request = PutMovieRequest.builder()
                            .title(title)
                            .releaseYear(releaseYear)
                            .director(directorId)
                            .build();
                        movieController.putMovie(UUID.randomUUID(), request);
                        System.out.println("Movie created successfully.");
                    } catch (NoSuchElementException ex) {
                        System.out.println("NOT_FOUND");
                    }
                }

                case "quit" -> {
                    break mainLoop;
                }
            }
        }
    }
}
