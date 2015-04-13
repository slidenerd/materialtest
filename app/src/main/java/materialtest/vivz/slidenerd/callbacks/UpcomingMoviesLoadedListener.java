package materialtest.vivz.slidenerd.callbacks;

import java.util.ArrayList;

import materialtest.vivz.slidenerd.pojo.Movie;

/**
 * Created by Windows on 13-04-2015.
 */
public interface UpcomingMoviesLoadedListener {
    public void onUpcomingMoviesLoaded(ArrayList<Movie> listMovies);
}
