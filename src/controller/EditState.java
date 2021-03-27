package controller;

public class EditState implements InputState {
    private ConsumableController controller;

    public EditState(ConsumableController controller) {
        this.controller = controller;
    }

    @Override
    public String getHeaderInfo() {
        return "Select consumable type to edit";
    }

    @Override
    public String getStateInfo() {
        return "1. Book\n" +
                "2. Movie\n" +
                "3. Series";
    }

    @Override
    public String getInputText() {
        return "Enter number: ";
    }

    @Override
    public void processInput(String input) {
        int index = Integer.parseInt(input);
        controller.setCurrentConsumableTypeIndex(index);
        controller.setCurrentState(controller.getEditListState());
    }

    @Override
    public void goBack() {

    }

    @Override
    public boolean shouldAddGap() {
        return true;
    }
}
