package controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EditStateTimeDate implements InputState{
    private ConsumableController controller;

    public EditStateTimeDate(ConsumableController controller) {
        this.controller = controller;
    }

    @Override
    public String getHeaderInfo() {
        return "Add consumption date";
    }

    @Override
    public String getStateInfo() {
        return "";
    }

    @Override
    public String getInputText() {
        return "date(yyyy-mm-dd): ";
    }

    @Override
    public void processInput(String input) {
        try {
            Date date = new SimpleDateFormat("yyyy-mm-dd").parse(input);
            controller.addConsumableTimeInHour(date);
        } catch (Exception e) {
            controller.addConsumableTimeInHour(null);
        }
        controller.setCurrentState(controller.getEditParameterState());
    }

    @Override
    public void goBack() {

    }

    @Override
    public boolean shouldAddGap() {
        return false;
    }
}
