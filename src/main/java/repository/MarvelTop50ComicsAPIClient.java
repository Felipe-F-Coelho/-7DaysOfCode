package repository;

import contract.APIClient;

import java.math.BigInteger;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Scanner;

public class MarvelTop50Comics implements APIClient {


    private final String privateKey;
    private final String publicKey;

    public MarvelTop50Comics() {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite a Chave Privada: ");
        this.privateKey = s.next();
        System.out.println("Digite a Chave Publica: ");
        this.publicKey = s.next();
    }

    @Override
    public String getBody() throws Exception {

        String ts = new Timestamp(System.currentTimeMillis()).toString();
        String md5Hash = ts + privateKey + publicKey;

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://gateway.marvel.com/v1/public/comics?format=comic&startYear=2019&limit=50&ts=%s&apikey=%s&hash=%s".formatted(ts,publicKey,md5Hash)))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    private String getMd5Hash(String s) throws NoSuchAlgorithmException {

        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(s.getBytes(),0,s.length());
        return ("MD5: "+new BigInteger(1,m.digest()).toString(16));

    }
}
