package controller;

import customexceptions.ConsumableEndedException;
import customexceptions.NegativeValueException;

public class EditStateRating implements InputState{
    private ConsumableController controller;

    public EditStateRating(ConsumableController controller) {
        this.controller = controller;
    }

    @Override
    public String getHeaderInfo() {
        return "Enter the new rating";
    }

    @Override
    public String getStateInfo() {
        return "";
    }

    @Override
    public String getInputText() {
        return "new rating(0-10): ";
    }

    @Override
    public void processInput(String input) {
        try {
            if (input.equals(""))
                controller.setConsumableRating(null);
            else
                controller.setConsumableRating(Float.parseFloat(input));
        } catch (ConsumableEndedException consumableEndedException) {
            consumableEndedException.printStackTrace();
        } catch (Exception e) { }
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
