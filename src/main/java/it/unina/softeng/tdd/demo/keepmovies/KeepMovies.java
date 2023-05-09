package it.unina.softeng.tdd.demo.keepmovies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KeepMovies {
    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }

    public KeepMovies() {
        movies = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void sortMoviesByTitle() {
        Collections.sort(movies, Comparator.comparing(Movie::getTitle));
    }

    public void sortMoviesByReleaseYear() {
        Collections.sort(movies, Comparator.comparing(Movie::getReleaseYear));
    }

}
