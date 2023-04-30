package patterns.task.MovieType;

public class Regular implements MovieType {
    @Override
    public double getAmount(int daysRented) {
        double res = 2;
        if (daysRented > 2)
            res += (daysRented - 2) * 1.5;
        return res;
    }

    @Override
    public String getType() {
        return "Regular";
    }
}
