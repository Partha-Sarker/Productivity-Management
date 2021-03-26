package controller;

public class CreatingState implements InputState {
    private ConsumableController controller;

    public CreatingState(ConsumableController controller) {
        this.controller = controller;
    }

    @Override
    public String getHeaderInfo() {
        return "Type the number associated with the option and press enter to create a consumable";
    }

    @Override
    public String getStateInfo() {
        String info = "Select the corresponding number to create that type of consumable\n" +
                "1. Book\n" +
                "2. Movie\n" +
                "3. Series";
        return info;
    }

    @Override
    public String getInputText() {
        return "Enter the corresponding digit: ";
    }

    @Override
    public void processInput(String input) {
        int command = Integer.parseInt(input);
        controller.setCurrentConsumableIndex(command);
        controller.setCurrentState(controller.getCreateStateName());
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
