package eti.timschopinski.movieapp.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class CreateMovieRequest {

    private String title;
    private Integer releaseYear;
    private UUID directorId;

}
