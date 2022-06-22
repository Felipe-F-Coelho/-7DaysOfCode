package domain;

import contract.Content;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Felipe Coelho
 * Classe Domain
 * Classe para encapsular os valores buscados em API-Marvel.
 */
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comics implements Content {

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
}
