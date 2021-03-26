package controller;

public class CreateStateRating implements InputState{
    private ConsumableController controller;

    public CreateStateRating(ConsumableController controller) {
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
        return "rating: ";
    }

    @Override
    public void processInput(String input) {
        try {
            controller.setRating(Float.parseFloat(input));
            controller.setCurrentState(controller.getCreateStateStartingDate());
        } catch (Exception e) {};
    }

    @Override
    public void goBack() {

    }

    @Override
    public boolean shouldAddGap() {
        return false;
    }
}
