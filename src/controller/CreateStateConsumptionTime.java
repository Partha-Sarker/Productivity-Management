package controller;

import java.text.ParseException;

public class CreateStateConsumptionTime implements InputState{
    private ConsumableController controller;

    public CreateStateConsumptionTime(ConsumableController controller) {
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
        return "consumption time: ";
    }

    @Override
    public void processInput(String input) {
        if (input.equals(""))
            controller.setConsumptionTimeInHour(0);
        else
            controller.setConsumptionTimeInHour(Double.parseDouble(input));
        try {
            controller.createConsumable();
            controller.setCurrentState(controller.getHomeState());
        } catch (ParseException e) {};
    }

    @Override
    public void goBack() {

    }

    @Override
    public void goHome() {

    }

    @Override
    public boolean shouldAddGap() {
        return true;
    }
}
