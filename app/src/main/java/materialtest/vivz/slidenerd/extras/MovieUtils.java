package materialtest.vivz.slidenerd.extras;

import com.android.volley.RequestQueue;

import org.json.JSONObject;

import java.util.ArrayList;

import materialtest.vivz.slidenerd.json.Endpoints;
import materialtest.vivz.slidenerd.json.Parser;
import materialtest.vivz.slidenerd.json.Requestor;
import materialtest.vivz.slidenerd.materialtest.MyApplication;
import materialtest.vivz.slidenerd.pojo.Movie;

/**
 * Created by Windows on 02-03-2015.
 */
public class MovieUtils {
    public static ArrayList<Movie> loadBoxOfficeMovies(RequestQueue requestQueue) {
        JSONObject response = Requestor.sendRequestBoxOfficeMovies(requestQueue, Endpoints.getRequestUrl(30));
        ArrayList<Movie> listMovies = Parser.parseJSONResponse(response);
        MyApplication.getWritableDatabase().insertMoviesBoxOffice(listMovies, true);
        return listMovies;
    }
}
