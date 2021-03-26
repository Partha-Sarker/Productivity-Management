import java.text.ParseException;

public class Movie extends Consumable {
    public Movie(String name) {
        super(name);
    }

    public Movie(String name, float rating) {
        super(name, rating);
    }

    public Movie(String name, String startingDate) throws ParseException {
        super(name, startingDate);
    }

    public Movie(String name, String startingDate, String endingDate) throws ParseException {
        super(name, startingDate, endingDate);
    }

    public Movie(String name, float rating, String startingDate) throws ParseException {
        super(name, rating, startingDate);
    }

    public Movie(String name, float rating, String startingDate, String endingDate) throws ParseException {
        super(name, rating, startingDate, endingDate);
    }

    public Movie(String name, double totalConsumptionTimeInHours) {
        super(name, totalConsumptionTimeInHours);
    }

    public Movie(String name, float rating, double totalConsumptionTimeInHours) {
        super(name, rating, totalConsumptionTimeInHours);
    }

    public Movie(String name, String startingDate, double totalConsumptionTimeInHours) throws ParseException {
        super(name, startingDate, totalConsumptionTimeInHours);
    }

    public Movie(String name, String startingDate, String endingDate, double totalConsumptionTimeInHours) throws ParseException {
        super(name, startingDate, endingDate, totalConsumptionTimeInHours);
    }

    public Movie(String name, float rating, String startingDate, double totalConsumptionTimeInHours) throws ParseException {
        super(name, rating, startingDate, totalConsumptionTimeInHours);
    }

    public Movie(String name, float rating, String startingDate, String endingDate, double totalConsumptionTimeInHours) throws ParseException {
        super(name, rating, startingDate, endingDate, totalConsumptionTimeInHours);
    }

    @Override
    public String toString() {
        return "Movie: " + super.toString();
    }
}
