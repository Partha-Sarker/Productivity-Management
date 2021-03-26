package model;

import customexceptions.ConsumableEndedException;
import customexceptions.NegativeValueException;

import java.text.ParseException;
import java.util.*;

public class ConsumableModel {
    private List<Consumable> bookList = new ArrayList<>();
    private List<Consumable> seriesList = new ArrayList<>();
    private List<Consumable> movieList = new ArrayList<>();

    public ConsumableModel() {
        try {
            bookList.add(new Book("book1", null, null, null, 0));
            bookList.add(new Book("book2", null, null, null, 0));
            bookList.add(new Book("book3", null, null, null, 0));
            movieList.add(new Movie("movie1", null, null, null, 0));
            movieList.add(new Movie("movie2", null, null, null, 0));
            movieList.add(new Movie("movie3", null, null, null, 0));
            seriesList.add(new Series("series1", null, null, null, 0));
            seriesList.add(new Series("series2", null, null, null, 0));
            seriesList.add(new Series("series3", null, null, null, 0));
        } catch (Exception e) {}
    }

    public List<Consumable> getBookList() {
        return bookList;
    }

    public List<Consumable> getSeriesList() {
        return seriesList;
    }

    public List<Consumable> getMovieList() {
        return movieList;
    }

    public void createBook(String name, Float rating, Date startingDate, Date endingDate, double consumptionTimeInHours) throws ParseException, NegativeValueException, ConsumableEndedException {
        bookList.add(new Book(name, rating, startingDate, endingDate, consumptionTimeInHours));
    }

    public void createSeries(String name, Float rating, Date startingDate, Date endingDate, double consumptionTimeInHours) throws ParseException, NegativeValueException, ConsumableEndedException {
        seriesList.add(new Series(name, rating, startingDate, endingDate, consumptionTimeInHours));
    }

    public void createMovie(String name, Float rating, Date startingDate, Date endingDate, double consumptionTimeInHours) throws ParseException, NegativeValueException, ConsumableEndedException {
        movieList.add(new Movie(name, rating, startingDate, endingDate, consumptionTimeInHours));
    }

    public void deleteBook(int index) {
        bookList.remove(index);
    }

    public void deleteMovie(int index) {
        movieList.remove(index);
    }

    public void deleteSeries(int index) {
        seriesList.remove(index);
    }

    public int getBookConsumeDays() {
        return Book.consumptionMap.keySet().size();
    }

    public int getSeriesConsumeDays() {
        return Series.consumptionMap.keySet().size();
    }

    public int getMovieConsumeDays() {
        return Movie.consumptionMap.keySet().size();
    }

    public double getBookConsumeHour() {
        return Book.totalConsumptionInHour;
    }

    public double getMovieConsumeHour() {
        return Movie.totalConsumptionInHour;
    }

    public double getSeriesConsumeHour() {
        return Series.totalConsumptionInHour;
    }

    public double getOverallConsumeHour() {
        return Book.totalConsumptionInHour + Movie.totalConsumptionInHour + Series.totalConsumptionInHour;
    }

    public int getOverallConsumptionDays() {
        Set<Date> uniqueDays = new HashSet<>();
        uniqueDays.addAll(Book.consumptionMap.keySet());
        uniqueDays.addAll(Movie.consumptionMap.keySet());
        uniqueDays.addAll(Series.consumptionMap.keySet());
        return uniqueDays.size();
    }

    public float getAverageBookRating() {
        float sum = 0;
        int count = 0;
        for (Consumable book : bookList) {
            if (book.getRating() == null)
                continue;
            sum += book.getRating();
            count++;
        }
        if (sum == 0)
            return 0;
        return sum / (float) count;
    }

    public float getAverageMovieRating() {
        float sum = 0;
        int count = 0;
        for (Consumable movie : movieList) {
            if (movie.getRating() == null)
                continue;
            sum += movie.getRating();
            count++;
        }
        if (sum == 0)
            return 0;
        return sum / (float) count;
    }

    public float getAverageSeriesRating() {
        float sum = 0;
        int count = 0;
        for (Consumable series : seriesList) {
            if (series.getRating() == null)
                continue;
            sum += series.getRating();
            count++;
        }
        if (sum == 0)
            return 0;
        return sum / (float) count;
    }

    public float getAverageConsumableRating() {
        return (getAverageBookRating() + getAverageSeriesRating() + getAverageMovieRating()) / 3f;
    }

    public int getBookCount() {
        return bookList.size();
    }

    public int getMovieCount() {
        return movieList.size();
    }

    public int getSeriesCount() {
        return seriesList.size();
    }

    public int getConsumableCount() {
        return getBookCount() + getMovieCount() + getSeriesCount();
    }

}
