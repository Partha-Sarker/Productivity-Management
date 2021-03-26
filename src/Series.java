import java.text.ParseException;

public class Series extends Consumable {


    public Series(String name) {
        super(name);
    }

    public Series(String name, float rating) {
        super(name, rating);
    }

    public Series(String name, String startingDate) throws ParseException {
        super(name, startingDate);
    }

    public Series(String name, String startingDate, String endingDate) throws ParseException {
        super(name, startingDate, endingDate);
    }

    public Series(String name, float rating, String startingDate) throws ParseException {
        super(name, rating, startingDate);
    }

    public Series(String name, float rating, String startingDate, String endingDate) throws ParseException {
        super(name, rating, startingDate, endingDate);
    }

    public Series(String name, double totalConsumptionTimeInHours) {
        super(name, totalConsumptionTimeInHours);
    }

    public Series(String name, float rating, double totalConsumptionTimeInHours) {
        super(name, rating, totalConsumptionTimeInHours);
    }

    public Series(String name, String startingDate, double totalConsumptionTimeInHours) throws ParseException {
        super(name, startingDate, totalConsumptionTimeInHours);
    }

    public Series(String name, String startingDate, String endingDate, double totalConsumptionTimeInHours) throws ParseException {
        super(name, startingDate, endingDate, totalConsumptionTimeInHours);
    }

    public Series(String name, float rating, String startingDate, double totalConsumptionTimeInHours) throws ParseException {
        super(name, rating, startingDate, totalConsumptionTimeInHours);
    }

    public Series(String name, float rating, String startingDate, String endingDate, double totalConsumptionTimeInHours) throws ParseException {
        super(name, rating, startingDate, endingDate, totalConsumptionTimeInHours);
    }

    @Override
    public String toString() {
        return "Series: " + super.toString();
    }
}
