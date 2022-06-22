package service;

import domain.Movie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MovieOrganizer {

    List<Movie> listMovies;

    public MovieOrganizer(String json) throws JSONException {

        listMovies = new ArrayList<>();

        JSONArray jsonArray = new JSONObject(json).getJSONArray("items");

        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject jsonObject = new JSONObject(jsonArray.get(i).toString());
            listMovies.add(Movie.builder()
                    .title(jsonObject.get("title").toString())
                    .rating(Integer.parseInt(jsonObject.get("rank").toString()))
                    .urlImagem(jsonObject.get("image").toString())
                    .year(Integer.parseInt(jsonObject.get("year").toString()))
                    .build());
        }

    }

    public List<Movie> get() {
        return this.listMovies;
    }

}
