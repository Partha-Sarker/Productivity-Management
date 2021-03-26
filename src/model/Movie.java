package model;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Movie extends Consumable {
    private static double totalConsumptionInHour = 0;
    private static Map<Date, Double> consumptionMap = new HashMap<>();

    public Movie(String name, Float rating, Date startingDate, Date endingDate, double consumptionTimeInHours) throws ParseException {
        super(name, rating, startingDate, endingDate, consumptionTimeInHours);
    }

    @Override
    public void addConsumptionTimeInHoursWithDay(double hour, Date day) {
        addConsumptionTimeInHours(hour);
        if (day == null)
            return;

        Double prevTime = consumptionMap.get(day);
        if (prevTime == null)
            consumptionMap.put(day, prevTime);
        else
            consumptionMap.put(day, prevTime + hour);
    }

    @Override
    public void addToTotalConsumptionTimeInHours(double hour) {
        totalConsumptionInHour += hour;
    }

    @Override
    public double getTotalConsumptionTimeInHours() {
        return totalConsumptionInHour;
    }

    @Override
    public String toString() {
        return "model.Movie: " + super.toString();
    }
}
