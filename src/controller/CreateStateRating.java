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
        if (input.equals(""))
            controller.setRating(null);
        else
            controller.setRating(Float.parseFloat(input));
        controller.setCurrentState(controller.getCreateStateStartingDate());
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
