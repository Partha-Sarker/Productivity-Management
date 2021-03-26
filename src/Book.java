import java.text.ParseException;

public class Book extends Consumable {
    public Book(String name) {
        super(name);
    }

    public Book(String name, float rating) {
        super(name, rating);
    }

    public Book(String name, String startingDate) throws ParseException {
        super(name, startingDate);
    }

    public Book(String name, String startingDate, String endingDate) throws ParseException {
        super(name, startingDate, endingDate);
    }

    public Book(String name, float rating, String startingDate) throws ParseException {
        super(name, rating, startingDate);
    }

    public Book(String name, float rating, String startingDate, String endingDate) throws ParseException {
        super(name, rating, startingDate, endingDate);
    }

    public Book(String name, double totalConsumptionTimeInHours) {
        super(name, totalConsumptionTimeInHours);
    }

    public Book(String name, float rating, double totalConsumptionTimeInHours) {
        super(name, rating, totalConsumptionTimeInHours);
    }

    public Book(String name, String startingDate, double totalConsumptionTimeInHours) throws ParseException {
        super(name, startingDate, totalConsumptionTimeInHours);
    }

    public Book(String name, String startingDate, String endingDate, double totalConsumptionTimeInHours) throws ParseException {
        super(name, startingDate, endingDate, totalConsumptionTimeInHours);
    }

    public Book(String name, float rating, String startingDate, double totalConsumptionTimeInHours) throws ParseException {
        super(name, rating, startingDate, totalConsumptionTimeInHours);
    }

    public Book(String name, float rating, String startingDate, String endingDate, double totalConsumptionTimeInHours) throws ParseException {
        super(name, rating, startingDate, endingDate, totalConsumptionTimeInHours);
    }

    @Override
    public String toString() {
        return "Book: " + super.toString();
    }
}
