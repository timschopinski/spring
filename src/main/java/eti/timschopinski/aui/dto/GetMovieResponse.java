package eti.timschopinski.aui.dto;

import eti.timschopinski.aui.Director;
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

    private UUID id;
    private String title;
    private int releaseYear;

}
