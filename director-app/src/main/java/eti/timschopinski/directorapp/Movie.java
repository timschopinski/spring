package eti.timschopinski.directorapp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    private UUID id;

    private String title;
    private int releaseYear;

    @ManyToOne
    @JoinColumn(name = "director_id")
    @JsonIgnoreProperties("directedMovies")
    private Director director;

}
