package service;

import contract.Content;

import java.io.PrintWriter;
import java.util.List;

/**
 * @author Felipe Coelho
 * Classe Service
 * Classe para gerar paginas HTML de acordo com as listas de extends Content.
 */
public class HTMLGenerator {

    PrintWriter writer;

    /**
     * @author Felipe Coelho
     * @param nameOfPage
     * Metodo construtor para iniciar o writer de acordo com o nome da pagina.
     */
    public HTMLGenerator(String nameOfPage) throws Exception {
        this.writer = new PrintWriter(nameOfPage);
    }

    /**
     * @author Felipe Coelho
     * @param contentList
     * @return void
     * Metodo que irá gerar o arquivo .HTML para ser consumido na web.
     */
    public void generate(List<? extends Content> contentList) {

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
        for (Content content: contentList) {
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
                    """.formatted(content.urlImage(),content.rating().toString(),content.title(),content.year().toString()));
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

    /**
     * @author Felipe Coelho
     * @return void
     * Metodo para finalizar a chamada do writer.
     */
    public void close() {
        this.writer.close();
    }
}
