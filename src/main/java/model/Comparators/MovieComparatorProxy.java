package model.Comparators;

import model.Movie;

import java.util.Comparator;

public class MovieComparatorProxy implements Comparator<Movie> {
    private MovieComparator movieComparator;

    public MovieComparatorProxy() {
        this.movieComparator = new MovieComparator();
    }

    @Override
    public int compare(Movie m1, Movie m2) {
        // Delegate the comparison to the original MovieComparator object
        return movieComparator.compare(m1, m2);
    }
}
