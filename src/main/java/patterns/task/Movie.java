package patterns.task;

import patterns.task.MovieGenre.MovieGenre;
import patterns.task.MovieType.MovieType;

import java.util.Objects;

public class Movie {
    private final String title;
    private MovieType type;
    private MovieType priceCode;
    private int year;
    private int daysRented;
    private String country;
    private MovieGenre genre;

    public Movie(String title, MovieType type, MovieType priceCode, int daysRented, int year, String country, MovieGenre genre) {
        this.title = title;
        this.type = type;
        this.priceCode = priceCode;
        this.daysRented = daysRented;
        this.year = year;
        this.country = country;
        this.genre = genre;
    }

    public MovieType getPriceCode() {
        return priceCode;
    }

    public String getTitle() {
        return title;
    }

    public int getYear(){
        return year;
    }

    public String getCountry(){
        return country;
    }

    public String getGen(){
        return genre.getGenre();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return "title='" + title + '\'' +
                ", type=" + type.getType() +
                ", priceCode=" + priceCode.getAmount(daysRented) +
                ", year=" + year +
                ", country='" + country + '\'' +
                ", genre=" + genre.getGenre();
    }
}