package service;

import domain.Movies;

import java.io.PrintWriter;
import java.util.List;

public class HTMLGenerator {

    PrintWriter writer;

    public HTMLGenerator(String nameOfPage) throws Exception {
        this.writer = new PrintWriter(nameOfPage);
    }

    public void generate(List<Movies> listMovie) {

        String head =
                """
                    <head>
                        <meta charset="utf-8">
                        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
                        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
                            + "integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
                        </head>
                        """;

        StringBuilder body = new StringBuilder();
        for (Movies movie: listMovie) {
            body.append("""
                    <body>
                        <div class="lister-item mode-detail">
                            <div class="card" style="width: 18rem;">
                                <img class="card-img-top" src="%s" alt="Card image cap">
                                <div class="card-body">
                                    <span class="lister-item-index unbold text-primary">Rank %s - </span>
                                    <a href="/title/tt0051087/?ref_=ttls_li_tt">%s</a>
                                    <span class="lister-item-year text-muted unbold">(%s)</span>
                                </div>
                            </div>
                        </div>
                    </body>
                    """.formatted(movie.getUrlImagem(),movie.getRating().toString(),movie.getTitle(),movie.getYear().toString()));
        }
        String html =
                """
                <html>
                %s
                %s
                </html>
                """.formatted(head,body);

        this.writer.print(html);
    }

    public void close() {
        this.writer.close();
    }
}
