package eti.timschopinski.movieapp.function;//package eti.timschopinski.aui.function;
//
//import eti.timschopinski.aui.Director;
//import eti.timschopinski.aui.Movie;
//import eti.timschopinski.aui.dto.PutMovieRequest;
//import org.springframework.stereotype.Component;
//import java.util.UUID;
//import java.util.function.BiFunction;
//
//
//@Component
//public class RequestToDirectorFunction implements BiFunction<UUID, PutMovieRequest, Movie> {
//
//    @Override
//    public Director apply(UUID id, PutMovieRequest request) {
//        return Director.builder()
//                .id(id)
//                .title(request.getTitle())
//                .releaseYear(request.getReleaseYear())
//                .director(Director.builder()
//                        .id(request.getDirector())
//                        .build())
//                .build();
//    }
//
//}
