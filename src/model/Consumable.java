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
    int consumptionDays = 0;

    public Consumable(String name, Float rating, Date startingDate, Date endingDate, double consumptionTimeInHours) throws NegativeValueException, ConsumableEndedException {
        this.name = name;
        this.rating = rating;
        this.startingDate = startingDate;
        addConsumptionTimeInHours(consumptionTimeInHours);
        this.endingDate = endingDate;
    }

    public void setRating(Float rating) throws ValueBoundException, ConsumableEndedException {
        if (rating > 10 || rating < 0)
            throw new ValueBoundException();
        if (isEnded())
            throw new ConsumableEndedException();
        this.rating = rating;
    }

    public void setEndingDate(Date endingDate) {
        if (endingDate == null)
            return;
        this.endingDate = endingDate;
    }

    public int getConsumptionDays() {
        return consumptionDays;
    }

    public void addConsumptionTimeInHours(double hour) throws ConsumableEndedException, NegativeValueException {
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

    public String getName() {
        return name;
    }

    public Float getRating() {
        return rating;
    }

    public String getStartingDate() {
        return new SimpleDateFormat("yyyy-dd-mm").format(startingDate);
    }

    public String getEndingDate() {
        return new SimpleDateFormat("yyyy-dd-mm").format(endingDate);
    }

    public abstract void addToTotalConsumptionTimeInHours(double hour);
    public abstract void addConsumptionTimeInHoursWithDay(double hour, Date day) throws NegativeValueException, ConsumableEndedException;


    private boolean isEnded() {
        if (endingDate == null)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder finalString = new StringBuilder(name);
        if (rating != null) {
            finalString.append(", rating: ");
            finalString.append(rating);
        }
        if (startingDate != null) {
            finalString.append(", startingDate: ");
            finalString.append(getStartingDate());
        }
        if (endingDate != null) {
            finalString.append(", endingDate: ");
            finalString.append(getEndingDate());
        }
        if (getConsumptionTimeInHours() != 0) {
            finalString.append(", totalConsumptionTimeInHours: ");
            finalString.append(getConsumptionTimeInHours());
        }
        return finalString.toString();
    }
}
