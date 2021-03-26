package controller;

public class EditStateTime implements InputState{
    private ConsumableController controller;

    public EditStateTime(ConsumableController controller) {
        this.controller = controller;
    }

    @Override
    public String getHeaderInfo() {
        return "Add consumption time in hours";
    }

    @Override
    public String getStateInfo() {
        return "";
    }

    @Override
    public String getInputText() {
        return "time(hour): ";
    }

    @Override
    public void processInput(String input) {
        if (input.equals(""))
            controller.setConsumptionTimeInHour(null);
        else
            controller.setConsumptionTimeInHour(Double.parseDouble(input));
        controller.setCurrentState(controller.getEditStateTimeDate());
    }

    @Override
    public void goBack() {

    }

    @Override
    public boolean shouldAddGap() {
        return false;
    }
}
