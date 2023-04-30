package patterns.task.Filter;

import patterns.task.Movie;

import java.util.List;
import java.util.stream.Collectors;

public class YearFilter implements Filter {
    private int year;

    public YearFilter(int year) {
        this.year = year;
    }

    @Override
    public List<Movie> applyFilter(List<Movie> movies) {
        return movies.stream()
                .filter(movie -> movie.getYear() == year)
                .collect(Collectors.toList());
    }
}