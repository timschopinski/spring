package eti.timschopinski.aui.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetMovieResponse {

    /**
     * Unique id identifying the movie.
     */
    private UUID id;

    /**
     * Title of the movie.
     */
    private String title;

    /**
     * Release year of the movie.
     */
    private int releaseYear;

}
