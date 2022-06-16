
import repository.IMDBTop250MoviesRepository;
import domain.Movies;
import org.json.JSONArray;
import org.json.JSONObject;
import service.HTMLGenerator;
import service.MovieOrganizer;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ConsumerAPIApplication {
    public static void main(String[] args) throws Exception {

        JSONArray jsonArrayTop250 = new IMDBTop250MoviesRepository().get();

        List<Movies> listMovie = new MovieOrganizer().get(jsonArrayTop250);

        HTMLGenerator htmlGenerator = new HTMLGenerator("IMDBTop250Movies.7DaysCode.com.br.html");

        htmlGenerator.generate(listMovie);

        htmlGenerator.close();
    }
}
