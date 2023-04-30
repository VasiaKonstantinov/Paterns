package patterns.task.Filter;

import patterns.task.Movie;
import patterns.task.MovieGenre.MovieGenre;

import java.util.List;
import java.util.stream.Collectors;

public class GenreFilter implements Filter{
    private String genre;

    public GenreFilter(String genre) {
        this.genre = genre;
    }

    @Override
    public List<Movie> applyFilter(List<Movie> movies) {
        return movies.stream()
                .filter(movie -> movie.getGen().equals(genre))
                .collect(Collectors.toList());
    }
}
