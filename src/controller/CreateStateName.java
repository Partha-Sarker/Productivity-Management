package controller;

public class CreateStateName implements InputState{
    private ConsumableController controller;

    public CreateStateName(ConsumableController controller) {
        this.controller = controller;
    }

    @Override
    public String getHeaderInfo() {
        return "Creating new consumable";
    }

    @Override
    public String getStateInfo() {
        return "";
    }

    @Override
    public String getInputText() {
        return "name: ";
    }

    @Override
    public void processInput(String input) {
        controller.setName(input);
        controller.setCurrentState(controller.getCreateStateRating());
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
