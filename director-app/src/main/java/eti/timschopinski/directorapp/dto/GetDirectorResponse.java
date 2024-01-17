package eti.timschopinski.directorapp.dto;

import eti.timschopinski.directorapp.Movie;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetDirectorResponse {

        private UUID id;
        private String name;
        private int age;
        private List<Movie> movies;
}