package repository;

import contract.APIClient;
import contract.TypeEnum;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

/**
 * @author Felipe Coelho
 * Classe Repository
 * Classe para efetuar chamada na API-IMDB e preparar o Json.
 */
public class ImdbTop250MoviesAPIClient implements APIClient {

    private final String apiKey;

    /**
     * @author Felipe Coelho
     * Metodo construtor para iniciar a chamada a API.
     */
    public ImdbTop250MoviesAPIClient() {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite a APIKey: ");
        this.apiKey = s.next();
    }

    /**
     * @author Felipe Coelho
     * @return String do response da API
     * Metodo get para formatar o request e efetuar a chamada da API.
     */
    @Override
    public String getBody() throws Exception {

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://imdb-api.com/en/API/Top250Movies/" + apiKey))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    @Override
    public TypeEnum type() {
        return TypeEnum.MOVIE;
    }
}
