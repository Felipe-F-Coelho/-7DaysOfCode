package domain;

import lombok.*;

import java.net.URL;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movies {

    private String title;
    private String urlImagem;
    @Id
    @Column(name = "id", nullable = false)
    private Integer rating;
    private Integer year;

    @Override
    public String toString() {
        return "Movies{" +
                "title='" + title + '\'' +
                ", urlImagem='" + urlImagem + '\'' +
                ", rating=" + rating +
                ", year=" + year +
                '}';
    }
}
