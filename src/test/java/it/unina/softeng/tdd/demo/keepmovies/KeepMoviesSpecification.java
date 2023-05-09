package it.unina.softeng.tdd.demo.keepmovies;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Year;
import java.util.List;

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
		KeepMovies keepMovies = new KeepMovies();
		keepMovies.addMovie(joker);
		keepMovies.addMovie(jojo);
		List<Movie> movies = keepMovies.getMovies();
		assertEquals(2, movies.size());
		assertTrue(movies.contains(joker));
		assertTrue(movies.contains(jojo));
	}
	
}
