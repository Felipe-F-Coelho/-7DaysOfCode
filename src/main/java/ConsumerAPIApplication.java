
import contract.Content;
import repository.ImdbTop250MoviesAPIClient;
import repository.MarvelTop50ComicsAPIClient;
import service.HTMLGenerator;
import service.ImdbMovieJsonParser;
import service.MarvelComicsJsonParser;

import java.util.List;

public class ConsumerAPIApplication{
    public static void main(String[] args) throws Exception {

        /*  ======  Processamento da API IMDB TOP 250 Movies ======  */

        /*      Solicitação via API dos Top 250 filmes      */

        String json = new ImdbTop250MoviesAPIClient().getBody();

        /*      Parseamento do Json para extrair somente o necessário e instancioando os objetos      */

        List<? extends Content> list = new ImdbMovieJsonParser(json).getParse();

        /*      Gerando HTML para WEB      */

        HTMLGenerator htmlGeneratorIMDB = new HTMLGenerator("IMDBTop250Movies.7DaysCode.com.br.html");
        htmlGeneratorIMDB.generate(list);
        htmlGeneratorIMDB.close();


        /*  ======  Processamento da API Marvel 50 Comics ======  */

        String jsonMarvel = new MarvelTop50ComicsAPIClient().getBody();

        List<? extends Content> listMarvel = new MarvelComicsJsonParser(jsonMarvel).getParse();

        HTMLGenerator htmlGeneratorMarvel = new HTMLGenerator("MarvelComics.7DaysCode.com.br.html");
        htmlGeneratorMarvel.generate(listMarvel);
        htmlGeneratorMarvel.close();

    }
}
