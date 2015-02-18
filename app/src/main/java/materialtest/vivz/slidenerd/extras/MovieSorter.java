package materialtest.vivz.slidenerd.extras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import materialtest.vivz.slidenerd.pojo.Movie;

/**
 * Created by Windows on 18-02-2015.
 */
public class MovieSorter {
    public void sortMoviesByName(ArrayList<Movie> movies){
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie lhs, Movie rhs) {
                return lhs.getTitle().compareTo(rhs.getTitle());
            }
        });
    }
    public void sortMoviesByDate(ArrayList<Movie> movies){

        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie lhs, Movie rhs) {
                return rhs.getReleaseDateTheater().compareTo(lhs.getReleaseDateTheater());
            }
        });
    }
    public void sortMoviesByRating(ArrayList<Movie> movies){
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie lhs, Movie rhs) {
                int ratingLhs=lhs.getAudienceScore();
                int ratingRhs=rhs.getAudienceScore();
                if(ratingLhs<ratingRhs)
                {
                    return 1;
                }
                else if(ratingLhs>ratingRhs)
                {
                    return -1;
                }
                else
                {
                    return 0;
                }
            }
        });
    }
}
