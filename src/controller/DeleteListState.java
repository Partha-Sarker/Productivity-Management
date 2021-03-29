package controller;

import model.Consumable;

import java.util.List;

public class DeleteListState implements InputState {
    private ConsumableController controller;

    public DeleteListState(ConsumableController controller) {
        this.controller = controller;
    }

    @Override
    public String getHeaderInfo() {
        return "Select a " + controller.getConsumableType() + " to delete";
    }

    @Override
    public String getStateInfo() {
        List<Consumable> consumableList = controller.getConsumableList();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < consumableList.size(); i++) {
            Consumable consumable = consumableList.get(i);
            builder.append(i + 1);
            builder.append(". ");
            builder.append(consumable);
            builder.append('\n');
        }
        return builder.toString();
    }

    @Override
    public String getInputText() {
        return "Enter " + controller.getConsumableType() + " number: ";
    }

    @Override
    public void processInput(String input) {
        int index = Integer.parseInt(input);
        controller.deleteConsumable(index - 1);
        controller.setCurrentState(controller.getDeleteState());
    }

    @Override
    public void goBack() {
        controller.setCurrentState(controller.getEditState());
    }

    @Override
    public boolean shouldAddGap() {
        return true;
    }
}
