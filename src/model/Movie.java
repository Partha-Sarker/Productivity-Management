package model;

import customexceptions.ConsumableEndedException;
import customexceptions.NegativeValueException;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Movie extends Consumable {
    static double totalConsumptionInHour = 0;
    static Map<Date, Double> consumptionMap = new HashMap<>();

    public Movie(String name, Float rating, Date startingDate, Date endingDate, double consumptionTimeInHours) throws ParseException, ConsumableEndedException, NegativeValueException {
        super(name, rating, startingDate, endingDate, consumptionTimeInHours);
    }

    @Override
    public void addConsumptionTimeInHoursWithDay(double hour, Date day) throws NegativeValueException, ConsumableEndedException {
        addConsumptionTimeInHours(hour);
        if (day == null)
            return;

        Double prevTime = consumptionMap.get(day);
        if (prevTime == null) {
            consumptionDays++;
            consumptionMap.put(day, prevTime);
        }
        else
            consumptionMap.put(day, prevTime + hour);
    }

    @Override
    public void addToTotalConsumptionTimeInHours(double hour) {
        totalConsumptionInHour += hour;
    }


    @Override
    public String toString() {
        return "Movie: " + super.toString();
    }
}
