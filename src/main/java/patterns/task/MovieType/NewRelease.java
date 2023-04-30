package patterns.task.MovieType;

public class NewRelease implements MovieType {
    @Override
    public double getAmount(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public String getType() {
        return "NewRelease";
    }
}
