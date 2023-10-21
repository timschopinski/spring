package eti.timschopinski.aui;
import java.util.*;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

@Builder
@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    private int age;

    @ManyToOne
    @JoinColumn(name = "movie")
    private Movie movie;

}
