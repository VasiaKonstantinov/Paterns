package patterns.task.Filter;

import patterns.task.Movie;

import java.util.List;

public interface Filter {
    List<Movie> applyFilter(List<Movie> movies);
}
