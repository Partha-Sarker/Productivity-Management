package controller;

import model.Consumable;
import model.ConsumableModel;
import view.ConsolePrinter;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ConsumableController {
    private ConsolePrinter printer;
    private ConsumableModel model;
    private InputState currentState, homeState;
    private InputState creatingState, createStateName, createStateRating, createStateStartingDate, createStateEndingDate, createStateConsumptionTime;
    private InputState editState, editListState, editParameterState, editRatingState, addTimeState, editEndingDateState;

    private String name;
    private Date startingDate, endingDate;
    private Float rating;
    private double consumptionTimeInHour;

    private static final int BOOK = 1, MOVIE = 2, SERIES = 3, ALL = 4;
    private int currentConsumableIndex = 1;
    private Consumable currentConsumable;


    public ConsumableController(ConsumableModel model, ConsolePrinter printer) {
        this.model = model;
        this.printer = printer;
        homeState = new HomeState(this);
        creatingState = new CreatingState(this);
        createStateName = new CreateStateName(this);
        createStateRating = new CreateStateRating(this);
        createStateStartingDate = new CreateStateStartingDate(this);
        createStateEndingDate = new CreateStateEndingDate(this);
        createStateConsumptionTime = new CreateStateConsumptionTime(this);
        editState = new EditState(this);
        editListState = new EditListState(this);
        editParameterState = new EditParameterState(this);
//        editRatingState = new EditRatingState(this);
//        addTimeState = new AddTimeState(this);
//        editEndingDateState = new EditEndingDateState(this);
        currentState = homeState;
    }


    public int getCurrentConsumableIndex() {
        return currentConsumableIndex;
    }

    public String getConsumableType() {
        if (currentConsumableIndex == 1)
            return "Book";
        if (currentConsumableIndex == 2)
            return "Movie";
        if (currentConsumableIndex == 3)
            return "Series";
        return "garbage";
    }

    public List<Consumable> getConsumableList() {
        if (currentConsumableIndex == BOOK)
            return model.getBookList();
        if (currentConsumableIndex == MOVIE)
            return model.getMoviesList();
        return model.getSeriesList();
    }

    public InputState getHomeState() {
        return homeState;
    }

    public InputState getCreatingState() {
        return creatingState;
    }

    public InputState getCreateStateName() {
        return createStateName;
    }

    public InputState getCreateStateRating() {
        return createStateRating;
    }

    public InputState getCreateStateStartingDate() {
        return createStateStartingDate;
    }

    public InputState getCreateStateEndingDate() {
        return createStateEndingDate;
    }

    public InputState getCreateStateConsumptionTime() {
        return createStateConsumptionTime;
    }

    public InputState getEditState() {
        return editState;
    }

    public InputState getEditListState() {
        return editListState;
    }

    public InputState getEditParameterState() {
        return editParameterState;
    }

    public InputState getEditRatingState() {
        return editRatingState;
    }

    public InputState getAddTimeState() {
        return addTimeState;
    }

    public InputState getEditEndingDateState() {
        return editEndingDateState;
    }



    public void setCurrentState(InputState currentState) {
        this.currentState = currentState;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public void setConsumptionTimeInHour(double consumptionTimeInHour) {
        this.consumptionTimeInHour = consumptionTimeInHour;
    }

    public void setCurrentConsumableIndex(int currentConsumableIndex) {
        this.currentConsumableIndex = currentConsumableIndex;
    }

    public void setCurrentConsumable(int index) {
        if (currentConsumableIndex == MOVIE) {
            currentConsumable = model.getMoviesList().get(index);
        }
        else if (currentConsumableIndex == BOOK) {
            currentConsumable = model.getBookList().get(index);
        }
        else if (currentConsumableIndex == SERIES) {
            currentConsumable = model.getSeriesList().get(index);
        }
    }



    public void createConsumable() throws ParseException {
        String consumableType = "";
        if (currentConsumableIndex == BOOK) {
            model.createBook(name, rating, startingDate, endingDate, consumptionTimeInHour);
            consumableType = "Book";
        }
        else if (currentConsumableIndex == MOVIE) {
            model.createMovie(name, rating, startingDate, endingDate, consumptionTimeInHour);
            consumableType = "Movie";
        }
        else if (currentConsumableIndex == SERIES) {
            model.createSeries(name, rating, startingDate, endingDate, consumptionTimeInHour);
            consumableType = "Series";
        }
        printer.displayNewLine();
        printer.displayTextWithNewLine(consumableType + " created successfully");
    }

    public static void main(String[] args) {
        ConsumableModel model = new ConsumableModel();
        ConsolePrinter printer = new ConsolePrinter();
        ConsumableController controller = new ConsumableController(model, printer);
        controller.startApplication();
    }


    public void startApplication() {
        printer.addGap();
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (true) {
            if (input.equals("quit"))
                break;

            String headerText = currentState.getHeaderInfo();
            String infoText = currentState.getStateInfo();
            String inputText = currentState.getInputText();

            if (!headerText.equals("")) {
                printer.displayTextWithNewLine(headerText);
                printer.displayHorizontalLine();
            }
            if (!infoText.equals("")) {
                printer.displayTextWithNewLine(infoText);
                printer.displayHorizontalLine();
            }
            if (!inputText.equals("")) {
                printer.displayText(inputText);
            }

            input = scanner.nextLine();
            if (currentState.shouldAddGap())
                printer.addGap();
            currentState.processInput(input);
        }
    }
}
