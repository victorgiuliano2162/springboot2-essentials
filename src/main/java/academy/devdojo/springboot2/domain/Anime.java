package academy.devdojo.springboot2.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //gera getters and setters, equals and hashcode
@AllArgsConstructor
public class Anime {
    private Long id;
    private String name;
}


