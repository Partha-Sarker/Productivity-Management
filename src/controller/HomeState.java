package controller;

public class HomeState implements InputState{
    private ConsumableController controller;

    public HomeState(ConsumableController controller) {
        this.controller = controller;
    }

    @Override
    public String getHeaderInfo() {
        return "Type the number associated with the option and press enter to continue";
    }

    @Override
    public String getStateInfo() {
        String info = "1. Create a consumable\n" +
                "2. Edit a consumable\n" +
                "3. Delete a consumable\n" +
                "4. See consumable list\n" +
                "5. See overall info";
        return info;
    }

    @Override
    public String getInputText() {
        return "Enter the corresponding digit: ";
    }

    @Override
    public void processInput(String input) {
        if (input.equals(""))
            return;
        int command = Integer.parseInt(input);
        switch (command) {
            case 1:
                controller.setCurrentState(controller.getCreatingState());
                break;
            case 2:
                controller.setCurrentState(controller.getEditState());
                break;
            case 3:
                controller.setCurrentState(controller.getDeleteState());
                break;
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
