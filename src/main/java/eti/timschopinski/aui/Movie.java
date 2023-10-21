package eti.timschopinski.aui;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String title;
    private int releaseYear;

    @OneToMany(mappedBy = "movie")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Actor> actors;


}
