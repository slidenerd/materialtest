package materialtest.vivz.slidenerd.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.RequestQueue;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import materialtest.vivz.slidenerd.adapters.AdapterBoxOffice;
import materialtest.vivz.slidenerd.callbacks.BoxOfficeMoviesLoadedListener;
import materialtest.vivz.slidenerd.extras.MovieSorter;
import materialtest.vivz.slidenerd.extras.SortListener;
import materialtest.vivz.slidenerd.logging.L;
import materialtest.vivz.slidenerd.materialtest.MyApplication;
import materialtest.vivz.slidenerd.materialtest.R;
import materialtest.vivz.slidenerd.network.VolleySingleton;
import materialtest.vivz.slidenerd.pojo.Movie;
import materialtest.vivz.slidenerd.task.TaskLoadMoviesBoxOffice;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentBoxOffice#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentBoxOffice extends Fragment implements SortListener, BoxOfficeMoviesLoadedListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String STATE_MOVIES = "state_movies";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private VolleySingleton volleySingleton;
    private ImageLoader imageLoader;
    private RequestQueue requestQueue;
    private ArrayList<Movie> listMovies = new ArrayList<>();
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private AdapterBoxOffice adapterBoxOffice;
    private RecyclerView listMovieHits;
    private TextView textVolleyError;
    private MovieSorter movieSorter;

    public FragmentBoxOffice() {
        // Required empty public constructor
        movieSorter = new MovieSorter();
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentBoxOffice.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentBoxOffice newInstance(String param1, String param2) {
        FragmentBoxOffice fragment = new FragmentBoxOffice();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public void onMoviesLoaded() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_box_office, container, false);
        textVolleyError = (TextView) view.findViewById(R.id.textVolleyError);
        listMovieHits = (RecyclerView) view.findViewById(R.id.listMovieHits);
        listMovieHits.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapterBoxOffice = new AdapterBoxOffice(getActivity());
        listMovieHits.setAdapter(adapterBoxOffice);
        if (savedInstanceState != null) {
            listMovies = savedInstanceState.getParcelableArrayList(STATE_MOVIES);

        } else {
            listMovies = MyApplication.getWritableDatabase().getAllMoviesBoxOffice();
            if (listMovies.isEmpty()) {
                L.t(getActivity(), "executing task from fragment");
                new TaskLoadMoviesBoxOffice(this).execute();
            }
        }
        adapterBoxOffice.setMovies(listMovies);
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(STATE_MOVIES, listMovies);
    }


    private void handleVolleyError(VolleyError error) {
        textVolleyError.setVisibility(View.VISIBLE);
        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
            textVolleyError.setText(R.string.error_timeout);

        } else if (error instanceof AuthFailureError) {
            textVolleyError.setText(R.string.error_auth_failure);
            //TODO
        } else if (error instanceof ServerError) {
            textVolleyError.setText(R.string.error_auth_failure);
            //TODO
        } else if (error instanceof NetworkError) {
            textVolleyError.setText(R.string.error_network);
            //TODO
        } else if (error instanceof ParseError) {
            textVolleyError.setText(R.string.error_parser);
            //TODO
        }
    }


    public void onSortByName() {
        movieSorter.sortMoviesByName(listMovies);
        adapterBoxOffice.notifyDataSetChanged();

    }

    @Override
    public void onSortByDate() {
        movieSorter.sortMoviesByDate(listMovies);
        adapterBoxOffice.notifyDataSetChanged();
    }

    @Override
    public void onSortByRating() {
        movieSorter.sortMoviesByRating(listMovies);
        adapterBoxOffice.notifyDataSetChanged();
    }


    @Override
    public void onBoxOfficeMoviesLoaded(ArrayList<Movie> listMovies) {
        L.t(getActivity(), "onBoxOfficeMoviesLoaded Fragment");
        adapterBoxOffice.setMovies(listMovies);
    }
}
