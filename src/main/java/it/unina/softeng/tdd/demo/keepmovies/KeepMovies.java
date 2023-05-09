package it.unina.softeng.tdd.demo.keepmovies;

import java.util.ArrayList;
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
}
