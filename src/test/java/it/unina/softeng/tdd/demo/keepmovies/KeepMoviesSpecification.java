package it.unina.softeng.tdd.demo.keepmovies;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Year;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

class KeepMoviesSpecification {

	Movie joker, jojo, dunkirk, up;

	@BeforeEach
	void init() {
		joker   = new Movie("Joker",Year.of(2019),"thriller");
		jojo    = new Movie("Jojo Rabbit", Year.of(2019), "comedy-drama");
		dunkirk = new Movie("Dunkirk",Year.of(2017),"war");
		up      = new Movie("Up",Year.of(2009),"comedy-drama");
	}

	@Test
	public void testAddMovie() {
		// Add the movies to KeepMovies
		KeepMovies keepMovies = new KeepMovies();
		// Add movies
		keepMovies.addMovie(joker);
		keepMovies.addMovie(jojo);
		List<Movie> movies = keepMovies.getMovies();
		assertEquals(2, movies.size());
		assertTrue(movies.contains(joker));
		assertTrue(movies.contains(jojo));
	}

	@Test
	public void testSortMoviesByTitle() {
		// Add the movies to KeepMovies
		KeepMovies keepMovies = new KeepMovies();
		keepMovies.addMovie(jojo);
		keepMovies.addMovie(dunkirk);
		keepMovies.addMovie(up);
		keepMovies.addMovie(joker);
		//Sort movies by Title
		keepMovies.sortMoviesByTitle();
		List<Movie> sortedMovies = keepMovies.getMovies();
		assertEquals("Dunkirk", sortedMovies.get(0).getTitle());
		assertEquals("Jojo Rabbit", sortedMovies.get(1).getTitle());
		assertEquals("Joker", sortedMovies.get(2).getTitle());
		assertEquals("Up", sortedMovies.get(3).getTitle());
	}

	@Test
	public void testSortMoviesByReleaseYear() {
		// Add the movies to KeepMovies
		KeepMovies keepMovies = new KeepMovies();
		keepMovies.addMovie(jojo);
		keepMovies.addMovie(dunkirk);
		keepMovies.addMovie(up);
		keepMovies.addMovie(joker);
		//Sort movies by release year
		keepMovies.sortMoviesByReleaseYear();
		List<Movie> sortedMovies = keepMovies.getMovies();
		assertEquals("Up", sortedMovies.get(0).getTitle());
		assertEquals("Dunkirk", sortedMovies.get(1).getTitle());
		assertEquals("Jojo Rabbit", sortedMovies.get(2).getTitle());
		assertEquals("Joker", sortedMovies.get(3).getTitle());
	}

	@Test
	public void testRemoveWatchedMovies() {
		// Add the movies to KeepMovies
		KeepMovies keepMovies = new KeepMovies();
		keepMovies.addMovie(joker);
		keepMovies.addMovie(jojo);
		keepMovies.addMovie(dunkirk);

		// Mark a movie as watched
		jojo.setWatched(true);

		// Remove watched movies
		keepMovies.removeWatchedMovies();

		// Check that only unwatched movies remain
		List<Movie> movies = keepMovies.getMovies();
		assertEquals(2, movies.size());
		assertTrue(movies.contains(joker));
		assertTrue(movies.contains(dunkirk));
		assertFalse(movies.contains(jojo));
	}

	@Test
	public void testGroupMoviesByGenre() {
		// Add the movies to KeepMovies
		KeepMovies keepMovies = new KeepMovies();
		keepMovies.addMovie(joker);
		keepMovies.addMovie(jojo);
		keepMovies.addMovie(dunkirk);
		keepMovies.addMovie(up);

		// Group movies by genre
		Map<String, List<Movie>> moviesByGenre = keepMovies.groupMoviesByGenre();

		// Check that each movie is in the expected genre group
		assertEquals(2, moviesByGenre.get("comedy-drama").size());
		assertTrue(moviesByGenre.get("comedy-drama").contains(jojo));
		assertTrue(moviesByGenre.get("comedy-drama").contains(up));

		assertEquals(1, moviesByGenre.get("thriller").size());
		assertTrue(moviesByGenre.get("thriller").contains(joker));

		assertEquals(1, moviesByGenre.get("war").size());
		assertTrue(moviesByGenre.get("war").contains(dunkirk));


	}

	@Test
	public void testGroupMoviesByYear() {
		// Add the movies to KeepMovies
		KeepMovies keepMovies = new KeepMovies();
		keepMovies.addMovie(joker);
		keepMovies.addMovie(jojo);
		keepMovies.addMovie(dunkirk);
		keepMovies.addMovie(up);

		// Group movies by year
		Map<Year, List<Movie>> moviesByYear = keepMovies.groupMoviesByYear();

		// Check that each movie is in the expected year group
		assertEquals(2, moviesByYear.get(Year.of(2019)).size());
		assertTrue(moviesByYear.get(Year.of(2019)).contains(jojo));
		assertTrue(moviesByYear.get(Year.of(2019)).contains(joker));

		assertEquals(1, moviesByYear.get(Year.of(2009)).size());
		assertTrue(moviesByYear.get(Year.of(2009)).contains(up));

		assertEquals(1, moviesByYear.get(Year.of(2017)).size());
		assertTrue(moviesByYear.get(Year.of(2017)).contains(dunkirk));
	}



}
