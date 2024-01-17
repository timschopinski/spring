package eti.timschopinski.movieapp;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

import java.util.*;

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
    private Director director;

}
