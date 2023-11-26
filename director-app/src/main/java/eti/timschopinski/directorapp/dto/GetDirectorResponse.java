package eti.timschopinski.directorapp.dto;

import lombok.*;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetDirectorResponse {

        private UUID id;
        private String name;
        private int age;
}