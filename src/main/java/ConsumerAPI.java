
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.*;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsumerAPI {
    public static void main(String[] args) throws Exception {

        List<String> titles = new ArrayList<>();
        List<String> urlImages = new ArrayList<>();

        Scanner s = new Scanner(System.in);

        System.out.println("Digite a APIKey: ");
        String apiKey = s.next();

        HttpClient client = HttpClient.newBuilder()
                .version(Version.HTTP_2)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://imdb-api.com/en/API/Top250Movies/" + apiKey))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        JSONArray jsonArray = new JSONObject(json).getJSONArray("items");

        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject jsonObject = new JSONObject(jsonArray.get(i).toString());
            titles.add(jsonObject.get("title").toString());
            urlImages.add(jsonObject.get("image").toString());
        }
        System.out.println(titles);
        System.out.println(urlImages);
    }
}
