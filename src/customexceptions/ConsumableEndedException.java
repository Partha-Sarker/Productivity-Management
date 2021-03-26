package customexceptions;

public class ConsumableEndedException extends Exception{
    public ConsumableEndedException() {
        super("Can't edit consumable with end date.");
    }
}
