package patterns.task.Filter;

import patterns.task.Movie;

import java.util.List;
import java.util.stream.Collectors;

public class TitleFilter implements Filter {
    private String title;

    public TitleFilter(String title) {
        this.title = title;
    }

    @Override
    public List<Movie> applyFilter(List<Movie> movies) {
        return movies.stream()
                .filter(movie -> movie.getTitle().equals(title))
                .collect(Collectors.toList());
    }
}

