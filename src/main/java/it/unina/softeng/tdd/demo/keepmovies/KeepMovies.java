package it.unina.softeng.tdd.demo.keepmovies;

import java.time.Year;
import java.util.*;
import java.util.function.Function;

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

    public void removeWatchedMovies() {
        for (Movie movie : movies) {
            if (movie.isWatched()) {
                movies.remove(movie);
            }
        }
    }

    public Map<String, List<Movie>> groupMoviesByGenre() {
        Map<String, List<Movie>> moviesByGenre = new HashMap<>();
        for (Movie movie : movies) {
            String genre = movie.getGenre();
            if (!moviesByGenre.containsKey(genre)) {
                moviesByGenre.put(genre, new ArrayList<>());
            }
            moviesByGenre.get(genre).add(movie);
        }
        return moviesByGenre;
    }

    public Map<Year, List<Movie>> groupMoviesByYear() {
        Map<Year, List<Movie>> moviesByYear = new HashMap<>();
        for (Movie movie : movies) {
            Year year = movie.getReleaseYear();
            if (!moviesByYear.containsKey(year)) {
                moviesByYear.put(year, new ArrayList<>());
            }
            moviesByYear.get(year).add(movie);
        }
        return moviesByYear;
    }

    public <T> Map<T, List<Movie>> groupBy(Function<Movie, T> function) {
        Map<T, List<Movie>> grouping = new HashMap<T, List<Movie>>();
        for(Movie m : movies) {
            T key = function.apply(m);
            if( grouping.containsKey(key) ) {
                grouping.get(key).add(m);
            }
            else {
                List<Movie> list = new ArrayList<Movie>();
                list.add(m);
                grouping.put(key, list);
            }
        }
        return grouping;
    }




}
