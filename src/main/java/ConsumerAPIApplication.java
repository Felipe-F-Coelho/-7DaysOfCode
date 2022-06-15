
import Repository.IMDBTop250MoviesRepository;
import domain.Movies;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ConsumerAPIApplication {
    public static void main(String[] args) throws Exception {

        List<Movies> listMovie = new ArrayList<>();

        JSONArray jsonArrayTop250 = new IMDBTop250MoviesRepository().get();

        for (int i = 0; i < jsonArrayTop250.length(); i++){
            JSONObject jsonObject = new JSONObject(jsonArrayTop250.get(i).toString());
            listMovie.add(Movies.builder()
                            .title(jsonObject.get("fullTitle").toString())
                            .rating(Integer.parseInt(jsonObject.get("rank").toString()))
                            .urlImagem(jsonObject.get("title").toString())
                            .year(Integer.parseInt(jsonObject.get("year").toString()))
                    .build());
        }

        System.out.println(listMovie);
        System.out.println(listMovie.get(3));
    }
}
