package controller;

import java.util.List;

public class EditParameterState implements InputState {
    private ConsumableController controller;

    public EditParameterState(ConsumableController controller) {
        this.controller = controller;
    }

    @Override
    public String getHeaderInfo() {

        return "Select which parameter you want to edit";
    }

    @Override
    public String getStateInfo() {
        String info = "1. Edit rating\n" +
                "2. Edit starting date\n" +
                "3. Edit ending date\n" +
                "4. Add consumption time\n" +
                "5. See overall info";
        return info;
    }

    @Override
    public String getInputText() {
        return "Enter number: ";
    }

    @Override
    public void processInput(String input) {
//        int index = Integer.parseInt(input);
//        controller.setCurrentConsumableIndex(index);
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
