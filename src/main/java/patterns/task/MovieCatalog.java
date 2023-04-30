package patterns.task;

import patterns.task.Filter.Filter;
import patterns.task.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MovieCatalog {
    private final List<Movie> catalog = new ArrayList<>();

    public String addToCatalog(Movie movie){
        boolean hasTargetWord = catalog.stream().anyMatch(word -> word.equals(movie));
        if(hasTargetWord){
            return "We already have common film";
        }
        catalog.add(movie);
        return "Done";
    }

    public List<Movie> findMovies(Filter filter) {
        return filter.applyFilter(catalog);
    }

    public Movie getMovie(int index){
        return catalog.get(index);
    }

    public void getCatalog(){
        for(int i = 0; i < catalog.size(); i++){
            System.out.println((i+1) + " " + catalog.get(i));
        }
    }
}
