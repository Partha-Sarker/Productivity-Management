package model;

import customexceptions.ConsumableEndedException;
import customexceptions.DateException;
import customexceptions.NegativeValueException;
import customexceptions.ValueBoundException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class Consumable {
    private final String name;
    private Float rating;
    private Date startingDate, endingDate;
    private double consumptionTimeInHours = 0;

    public Consumable(String name, Float rating, Date startingDate, Date endingDate, double consumptionTimeInHours) {
        this.name = name;
        this.rating = rating;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        addConsumptionTimeInHours(consumptionTimeInHours);
    }

    public void setRating(Float rating) {
        if (rating > 10 || rating < 0)
            throw new ValueBoundException();
        if (isEnded())
            throw new ConsumableEndedException();
        this.rating = rating;
    }

//    private void setStartingDate(String startingDate) throws ParseException{
//        if (isEnded())
//            throw new ConsumableEndedException();
//        if (startingDate == null || startingDate.equals(""))
//            return;
//        this.startingDate = new SimpleDateFormat("YYYY-MM-DD").parse(startingDate);
//    }

    public void setEndingDate(Date endingDate) {
        if (endingDate == null)
            return;
        this.endingDate = endingDate;
    }

    public void addConsumptionTimeInHours(double hour) {
        if (isEnded())
            throw new ConsumableEndedException();
        if (hour < 0)
            throw new NegativeValueException();

        consumptionTimeInHours += hour;
        addToTotalConsumptionTimeInHours(hour);
    }

    public double getConsumptionTimeInHours() {
        return consumptionTimeInHours;
    }

    public abstract void addToTotalConsumptionTimeInHours(double hour);
    public abstract void addConsumptionTimeInHoursWithDay(double hour, Date day);
    public abstract double getTotalConsumptionTimeInHours();


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
        if (getTotalConsumptionTimeInHours() != 0) {
            finalString.append(", totalConsumptionTimeInHours: ");
            finalString.append(getConsumptionTimeInHours());
        }
        return finalString.toString();
    }
}
