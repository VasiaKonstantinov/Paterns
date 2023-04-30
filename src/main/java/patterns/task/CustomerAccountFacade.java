package patterns.task;

import patterns.task.MovieType.Rental;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class CustomerAccountFacade {
    private List<Customer> clients;
    private final String FilePath= "C:\\Users\\Василь\\IdeaProjects\\Paterns\\Paterns\\PatternsTask\\Account";

    public CustomerAccountFacade() {
        clients = new ArrayList<>();
    }

    public void addClient(Customer client) {
        clients.add(client);
    }

    public void saveToFile(Customer client) throws IOException {
        List<String> lines = new ArrayList<>();
            lines.add("Client: " + client.getName());
            lines.add("Rented movies:");
            for (Rental movie : client.getRentals()) {
                lines.add("  - " + movie.getMovieTitle() + " for " + movie.getDaysRented() + " days.");
            }
            lines.add("");
        Files.write(Path.of(FilePath), lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }
}

