package materialtest.vivz.slidenerd.task;

import android.os.AsyncTask;

import com.android.volley.RequestQueue;

import java.util.ArrayList;

import materialtest.vivz.slidenerd.callbacks.BoxOfficeMoviesLoadedListener;
import materialtest.vivz.slidenerd.extras.MovieUtils;
import materialtest.vivz.slidenerd.network.VolleySingleton;
import materialtest.vivz.slidenerd.pojo.Movie;

/**
 * Created by Windows on 02-03-2015.
 */
public class TaskLoadMoviesBoxOffice extends AsyncTask<Void, Void, ArrayList<Movie>> {
    private BoxOfficeMoviesLoadedListener myComponent;
    private VolleySingleton volleySingleton;
    private RequestQueue requestQueue;


    public TaskLoadMoviesBoxOffice(BoxOfficeMoviesLoadedListener myComponent) {

        this.myComponent = myComponent;
        volleySingleton = VolleySingleton.getInstance();
        requestQueue = volleySingleton.getRequestQueue();
    }


    @Override
    protected ArrayList<Movie> doInBackground(Void... params) {

        ArrayList<Movie> listMovies = MovieUtils.loadBoxOfficeMovies(requestQueue);
        return listMovies;
    }

    @Override
    protected void onPostExecute(ArrayList<Movie> listMovies) {
        if (myComponent != null) {
            myComponent.onBoxOfficeMoviesLoaded(listMovies);
        }
    }


}
