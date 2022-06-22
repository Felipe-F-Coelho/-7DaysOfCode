package service;

import domain.Movie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import contract.JsonParse;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Felipe Coelho
 * Classe Service
 * Classe para parsear os String de Json enviados na API-IMDB retornando uma lista de Movies.
 */
public class ImdbMovieJsonParser implements JsonParse {

    private final List<Movie> listMovies;

    /**
     * @author Felipe Coelho
     * @param json
     * Metodo construtor iniciar o parseamento do json e instanciar os objetos.
     */
    public ImdbMovieJsonParser(String json) throws JSONException {

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

    /**
     * @author Felipe Coelho
     * Metodo get para retornar o parseamento efetuado.
     */
    public List<Movie> getParse() {
        return this.listMovies;
    }

}
