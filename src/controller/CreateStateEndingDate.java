package controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateStateEndingDate implements InputState{
    private ConsumableController controller;

    public CreateStateEndingDate(ConsumableController controller) {
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
        return "ending date(yyyy-mm-dd): ";
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
        controller.setCurrentState(controller.getCreateStateConsumptionTime());
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