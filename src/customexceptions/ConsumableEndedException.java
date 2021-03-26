package customexceptions;

public class ConsumableEndedException extends RuntimeException{
    public ConsumableEndedException() {
        super("Can't edit consumable with end date.");
    }
}
