package service;

import contract.Content;
import contract.JsonParse;
import domain.Comics;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Felipe Coelho
 * Classe Service
 * Classe para parsear os String de Json enviados na API-Marvel retornando uma lista de Comics.
 */
public class MarvelComicsJsonParser implements JsonParse {

    private final List<Comics> comicsList;

    /**
     * @author Felipe Coelho
     * @param json
     * Metodo construtor iniciar o parseamento do json e instanciar os objetos.
     */
    public MarvelComicsJsonParser(String json) throws Exception {

        comicsList = new ArrayList<>();

        JSONObject data = new JSONObject(json).getJSONObject("data");

        JSONArray jsonArray = new JSONObject(data.toString()).getJSONArray("results");

        for (int i = 0; i < jsonArray.length(); i++){

            JSONObject jsonObject = new JSONObject(jsonArray.get(i).toString());
            JSONObject series = new JSONObject(jsonObject.toString()).getJSONObject("series");
            JSONObject thumbnail = new JSONObject(jsonObject.toString()).getJSONObject("thumbnail");
            JSONObject dates = (JSONObject) new JSONObject(jsonObject.toString()).getJSONArray("dates").get(0);
            String imagem = thumbnail.get("path").toString() + "/clean.jpg";

            comicsList.add(Comics.builder()
                    .title(series.get("name").toString())
                    .rating(i+1)
                    .urlImagem(imagem)
                    .year(Integer.parseInt(dates.get("date").toString().substring(0,4)))
                    .build());

            Collections.sort(comicsList);
        }
    }

    /**
     * @author Felipe Coelho
     * Metodo get para retornar o parseamento efetuado.
     */
    @Override
    public List<? extends Content> getParse() {
        return this.comicsList;
    }
}
