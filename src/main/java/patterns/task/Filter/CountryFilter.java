package patterns.task.Filter;

import patterns.task.Movie;

import java.util.List;
import java.util.stream.Collectors;

public class CountryFilter implements Filter{
    String country;

    public CountryFilter(String country) {
        this.country = country;
    }

    @Override
    public List<Movie> applyFilter(List<Movie> movies) {
        return movies.stream()
                .filter(movie -> movie.getTitle().equals(country))
                .collect(Collectors.toList());
    }
}
