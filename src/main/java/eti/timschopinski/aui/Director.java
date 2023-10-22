package eti.timschopinski.aui;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    private int age;

    @OneToMany(mappedBy = "director")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Movie> directedMovies;
}
