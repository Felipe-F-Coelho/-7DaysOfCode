package service;

import domain.Movies;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MovieOrganizer {

    public List<Movies> get(JSONArray jsonArrayTop250) throws Exception {

        List<Movies> listMovies = new ArrayList<>();

        for (int i = 0; i < jsonArrayTop250.length(); i++){
            JSONObject jsonObject = new JSONObject(jsonArrayTop250.get(i).toString());
            listMovies.add(Movies.builder()
                    .title(jsonObject.get("title").toString())
                    .rating(Integer.parseInt(jsonObject.get("rank").toString()))
                    .urlImagem(jsonObject.get("image").toString())
                    .year(Integer.parseInt(jsonObject.get("year").toString()))
                    .build());
        }

        return listMovies;
    }

}
