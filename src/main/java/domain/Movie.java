package domain;

import lombok.*;
import contract.Content;

import javax.persistence.*;

/**
 * @author Felipe Coelho
 * Classe Domain
 * Classe para encapsular os valores buscados em API-IMDB.
 */
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie implements Content,Comparable<Movie> {

    private String title;
    private String urlImagem;
    @Id
    @Column(name = "id", nullable = false)
    private Integer rating;
    private Integer year;

    @Override
    public String title() {
        return this.title;
    }

    @Override
    public String urlImage() {
        return this.urlImagem;
    }

    @Override
    public Integer rating() {
        return this.rating;
    }

    @Override
    public Integer year() {
        return this.year;
    }

    @Override
    public int compareTo(Movie outro) {
        return this.rating().compareTo(outro.rating());
    }
}
