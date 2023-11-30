package eti.timschopinski.movieapp;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "directors")
public class Director {
    @Id
    private UUID id;

    private String name;
    private int age;

    @OneToMany(mappedBy = "director", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Movie> directedMovies;
}
