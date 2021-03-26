package customexceptions;

public class ValueBoundException extends RuntimeException {
    public ValueBoundException() {
        super("Value not withing the bound");
    }
}
