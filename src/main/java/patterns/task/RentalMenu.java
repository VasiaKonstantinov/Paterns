package patterns.task;

import patterns.task.Filter.*;
import patterns.task.MovieGenre.*;
import patterns.task.MovieType.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentalMenu {
    private CustomerAccountFacade facade;
    private MovieCatalog movieCatalog = new MovieCatalog();
    private Scanner scanner;

    public RentalMenu() {
        facade = new CustomerAccountFacade();
        scanner = new Scanner(System.in);
    }

    public void printMenu() throws IOException {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Add a movie to the catalog");
            System.out.println("2. Rent a movie");
            System.out.println("3. View the movie catalog");
            System.out.println("4. Find a movie");
            System.out.println("5. Exit");

            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addFilm();
                case 2 -> rent();
                case 3 -> movieCatalog.getCatalog();
                case 4 -> System.out.println(findFilm());
                case 5 -> isRunning = false;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    public void addFilm() {
        System.out.println("Enter the movie title");
        String title = scanner.nextLine();
        MovieType type = whatType();
        System.out.println("Enter the movie year");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the movie country");
        String country = scanner.nextLine();
        System.out.println("Enter the movie genre");
        MovieGenre genre = whatGenre();
        Movie movie = new Movie(title, type, type, 1, year, country, genre);
        System.out.println(movieCatalog.addToCatalog(movie));
    }


    public MovieType whatType() {
        System.out.println("""
                Choose if the movie is:
                1. New release
                2. Regular
                3. Children""");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return switch (choice) {
            case 1 -> new NewRelease();
            case 2 -> new Regular();
            case 3 -> new Children();
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        };
    }

    public List<Movie> findFilm() {
        System.out.println("""
                Choose the search parameter:
                1. Title
                2. Year
                3. Country
                4. Genre""");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1" -> {
                System.out.println("Enter the title: ");
                String title = scanner.nextLine();
                Filter filterT = new TitleFilter(title);
                return movieCatalog.findMovies(filterT);
            }
            case "2" -> {
                System.out.println("Enter the year: ");
                int year = scanner.nextInt();
                scanner.nextLine();
                Filter filterY = new YearFilter(year);
                return movieCatalog.findMovies(filterY);
            }
            case "3" -> {
                System.out.println("Enter the country: ");
                String country = scanner.nextLine();
                Filter filterC = new CountryFilter(country);
                return movieCatalog.findMovies(filterC);
            }
            case "4" -> {
                System.out.println("Enter the genre: ");
                String genre = scanner.nextLine();
                Filter filterG = new GenreFilter(genre);
                return movieCatalog.findMovies(filterG);
            }
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }
    }


    public MovieGenre whatGenre() {
        System.out.println("""
                Choose the movie genre:
                1. Comedy
                2. Horror
                3. Drama
                4. Fantasy""");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Очистити буфер
        return switch (choice) {
            case 1 -> new Comedy();
            case 2 -> new Horror();
            case 3 -> new Drama();
            case 4 -> new Fantastic();
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        };
    }

    public void rent() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = in.nextLine();
        List<Rental> movieList = new ArrayList<>();
        boolean doContinue = true;
        while (doContinue) {
            Rental rental = chooseMovie();
            movieList.add(rental);
            System.out.println("If you want to add more, enter 'yes'");
            String answer = in.nextLine();
            doContinue = answer.equals("yes");
        }
        Customer newCustomer = new Customer(name, movieList);
        System.out.println();
        facade.saveToFile(newCustomer);
    }

    public Rental chooseMovie() {
        Scanner in = new Scanner(System.in);
        movieCatalog.getCatalog();
        System.out.println("Choose the movie you want to rent: ");
        int number = in.nextInt();
        System.out.println("Choose the rental period in days: ");
        int days = in.nextInt();
        return new Rental(movieCatalog.getMovie(number - 1), days);
    }
}

