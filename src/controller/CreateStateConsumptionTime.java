package controller;

import customexceptions.ConsumableEndedException;
import customexceptions.NegativeValueException;

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
        return "consumption time(hour): ";
    }

    @Override
    public void processInput(String input) {
        if (input.equals(""))
            controller.setConsumptionTimeInHour(0d);
        else
            controller.setConsumptionTimeInHour(Double.parseDouble(input));
        try {
            controller.createConsumable();
            controller.setCurrentState(controller.getHomeState());
        } catch (ParseException e) {} catch (ConsumableEndedException e) {
            e.printStackTrace();
        } catch (NegativeValueException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void goBack() {

    }

    @Override
    public boolean shouldAddGap() {
        return true;
    }
}
