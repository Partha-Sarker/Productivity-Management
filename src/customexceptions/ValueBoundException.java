package customexceptions;

public class ValueBoundException extends Exception {
    public ValueBoundException() {
        super("Value not withing the bound");
    }
}
