package repository;

import contract.APIClient;

import java.math.BigInteger;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * @author Felipe Coelho
 * Classe Repository
 * Classe para efetuar chamada na API-Marvel e preparar o Json.
 */
public class MarvelTop50ComicsAPIClient implements APIClient {

    private final String privateKey;
    private final String publicKey;

    /**
     * @author Felipe Coelho
     * Metodo construtor para iniciar a chamada a API.
     */
    public MarvelTop50ComicsAPIClient() {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite a Chave Privada: ");
        this.privateKey = s.next();
        System.out.println("Digite a Chave Publica: ");
        this.publicKey = s.next();
    }

    /**
     * @author Felipe Coelho
     * @return String do response da API
     * Metodo get para formatar o request e efetuar a chamada da API.
     */
    @Override
    public String getBody() throws Exception {

        String ts = String.valueOf(System.currentTimeMillis() / 1000L);
        String md5Hash = getMd5Hash(ts+privateKey+publicKey);
        String html = "https://gateway.marvel.com/v1/public/comics?format=comic&startYear=2019&limit=50&ts=%s&apikey=%s&hash=%s".formatted(ts,publicKey,md5Hash);

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(html))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    /**
     * @author Felipe Coelho
     * @param stringToMD5;
     * @return Uma String MD5
     * Metodo que formata a string com ts + privateKey + publickey em uma StringMD5.
     */
    private String getMd5Hash(String stringToMD5) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(stringToMD5.getBytes(),0,stringToMD5.length());
        return (new BigInteger(1,m.digest()).toString(16));
    }
}
