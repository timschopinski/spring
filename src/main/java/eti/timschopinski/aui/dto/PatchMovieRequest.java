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
public class PatchMovieRequest {

    private String title;
    private Integer releaseYear;
    private UUID director;
}
