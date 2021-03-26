package model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConsumableModel {
    private List<Consumable> bookList = new ArrayList<>();
    private List<Consumable> seriesList = new ArrayList<>();
    private List<Consumable> moviesList = new ArrayList<>();

    public ConsumableModel() {
        try {
            bookList.add(new Book("book1", null, null, null, 0));
            bookList.add(new Book("book2", null, null, null, 0));
            bookList.add(new Book("book3", null, null, null, 0));
            moviesList.add(new Book("movie1", null, null, null, 0));
            moviesList.add(new Book("movie2", null, null, null, 0));
            moviesList.add(new Book("movie3", null, null, null, 0));
            seriesList.add(new Book("series1", null, null, null, 0));
            seriesList.add(new Book("series2", null, null, null, 0));
            seriesList.add(new Book("series3", null, null, null, 0));
        } catch (Exception e) {}
    }

    public List<Consumable> getBookList() {
        return bookList;
    }

    public List<Consumable> getSeriesList() {
        return seriesList;
    }

    public List<Consumable> getMoviesList() {
        return moviesList;
    }

    public void createBook(String name, Float rating, Date startingDate, Date endingDate, double consumptionTimeInHours) throws ParseException {
        bookList.add(new Book(name, rating, startingDate, endingDate, consumptionTimeInHours));
    }

    public void createSeries(String name, Float rating, Date startingDate, Date endingDate, double consumptionTimeInHours) throws ParseException {
        seriesList.add(new Series(name, rating, startingDate, endingDate, consumptionTimeInHours));
    }

    public void createMovie(String name, Float rating, Date startingDate, Date endingDate, double consumptionTimeInHours) throws ParseException {
        moviesList.add(new Movie(name, rating, startingDate, endingDate, consumptionTimeInHours));
    }

    public void setBookRating(int index, float rating) {
        bookList.get(index).setRating(rating);
    }

    public void setMovieRating(int index, float rating) {
        moviesList.get(index).setRating(rating);
    }

    public void setSeriesRating(int index, float rating) {
        seriesList.get(index).setRating(rating);
    }
}
