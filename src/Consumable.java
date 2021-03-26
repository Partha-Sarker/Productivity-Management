import customexceptions.ConsumableEndedException;
import customexceptions.DateException;
import customexceptions.NegativeValueException;
import customexceptions.ValueBoundException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Consumable {
    private final String name;
    private Float rating;
    private double totalConsumptionTimeInHours = 0;
    private Date startingDate = null, endingDate = null;
    private int totalConsumptionDay = 0;

    public Consumable(String name) {
        this.name = name;
    }

    public Consumable(String name, float rating) {
        this(name);
        this.rating = rating;
    }

    public Consumable(String name, String startingDate) throws ParseException {
        this(name);
        this.startingDate = new SimpleDateFormat("YYYY-MM-DD").parse(startingDate);
    }

    public Consumable(String name, String startingDate, String endingDate) throws ParseException{
        this(name, startingDate);
        this.endingDate = new SimpleDateFormat("YYYY-MM-DD").parse(endingDate);
    }

    public Consumable(String name, float rating, String startingDate) throws ParseException {
        this(name, startingDate);
        this.rating = rating;
    }

    public Consumable(String name, float rating, String startingDate, String endingDate) throws ParseException {
        this(name, startingDate, endingDate);
        this.rating = rating;
    }

    public Consumable(String name, double totalConsumptionTimeInHours) {
        this(name);
        this.totalConsumptionTimeInHours = totalConsumptionTimeInHours;
    }

    public Consumable(String name, float rating, double totalConsumptionTimeInHours) {
        this(name, rating);
        this.totalConsumptionTimeInHours = totalConsumptionTimeInHours;
    }

    public Consumable(String name, String startingDate, double totalConsumptionTimeInHours) throws ParseException {
        this(name, startingDate);
        this.totalConsumptionTimeInHours = totalConsumptionTimeInHours;
    }

    public Consumable(String name, String startingDate, String endingDate, double totalConsumptionTimeInHours) throws ParseException {
        this(name, startingDate, endingDate);
        this.totalConsumptionTimeInHours = totalConsumptionTimeInHours;
    }

    public Consumable(String name, float rating, String startingDate, double totalConsumptionTimeInHours) throws ParseException {
        this(name, rating, startingDate);
        this.totalConsumptionTimeInHours = totalConsumptionTimeInHours;
    }

    public Consumable(String name, float rating, String startingDate, String endingDate, double totalConsumptionTimeInHours) throws ParseException {
        this(name, rating, startingDate, endingDate);
        this.totalConsumptionTimeInHours = totalConsumptionTimeInHours;
    }


    public void setRating(Float rating) {
        if (rating > 10 || rating < 0)
            throw new ValueBoundException();
        if (isEnded())
            throw new ConsumableEndedException();
        this.rating = rating;
    }

    public void setStartingDate(String startingDate) throws ParseException{
        if (isEnded())
            throw new ConsumableEndedException();
        this.startingDate = new SimpleDateFormat("YYYY-MM-DD").parse(startingDate);
    }

    public void setEndingDate(String endingDate) throws ParseException{
        Date newDate = new SimpleDateFormat("YYYY-MM-DD").parse(endingDate);
        if (startingDate != null && newDate.before(startingDate))
            throw new DateException();
        this.endingDate = newDate;
    }

    public void addConsumptionTimeInHours(double hour) {
        if (isEnded())
            throw new ConsumableEndedException();
        if (hour < 0)
            throw new NegativeValueException();
        totalConsumptionTimeInHours += hour;
    }

    public void addConsumptionTimeForDay(double hour) {
        if (isEnded())
            throw new ConsumableEndedException();
        if (hour < 0)
            throw new NegativeValueException();
        if (hour > 24)
            throw new ValueBoundException();
        totalConsumptionDay++;
        totalConsumptionTimeInHours += hour;
    }


    private boolean isEnded() {
        if (endingDate == null)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder finalString = new StringBuilder(name);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-dd-mm");
        if (rating != null) {
            finalString.append(", rating: ");
            finalString.append(rating);
        }
        if (startingDate != null) {
            finalString.append(", startingDate: ");
            finalString.append(dateFormat.format(startingDate));
        }
        if (endingDate != null) {
            finalString.append(", endingDate: ");
            finalString.append(dateFormat.format(endingDate));
        }
        finalString.append(", totalConsumptionTimeInHours: ");
        finalString.append(totalConsumptionTimeInHours);
        finalString.append(", totalConsumptionDay: ");
        finalString.append(totalConsumptionDay);
        return finalString.toString();
    }
}
