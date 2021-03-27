package controller;

import customexceptions.ConsumableEndedException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditStateEndingDate implements InputState{
    private ConsumableController controller;

    public EditStateEndingDate(ConsumableController controller) {
        this.controller = controller;
    }

    @Override
    public String getHeaderInfo() {
        return "Enter the new date";
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

            try {
                Date endingDate = new SimpleDateFormat("yyyy-mm-dd").parse(input);
                controller.setConsumableEndingDate(endingDate);
                controller.setCurrentState(controller.getEditParameterState());
            } catch (ConsumableEndedException p) {
                p.printStackTrace();
                goBack();
                return;
            } catch (ParseException p) {}
    }

    @Override
    public void goBack() {
        controller.setCurrentState(controller.getEditParameterState());
    }

    @Override
    public boolean shouldAddGap() {
        return false;
    }
}
