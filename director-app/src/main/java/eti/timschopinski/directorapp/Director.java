package eti.timschopinski.directorapp;
import java.util.*;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

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
