package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

public class CreateStateStartingDate implements InputState{
    private ConsumableController controller;

    public CreateStateStartingDate(ConsumableController controller) {
        this.controller = controller;
    }

    @Override
    public String getHeaderInfo() {
        return "";
    }

    @Override
    public String getStateInfo() {
        return "";
    }

    @Override
    public String getInputText() {
        return "start date(yyyy-mm-dd): ";
    }

    @Override
    public void processInput(String input) {
        if (input.equals(""))
            controller.setRating(null);
        else {
            try {
                Date date = new SimpleDateFormat("yyyy-mm-dd").parse(input);
                controller.setStartingDate(date);
            } catch (Exception e) {
                controller.setRating(null);
            }
        }
        controller.setCurrentState(controller.getCreateStateEndingDate());
    }

    @Override
    public void goBack() {

    }

    @Override
    public void goHome() {

    }

    @Override
    public boolean shouldAddGap() {
        return false;
    }
}
