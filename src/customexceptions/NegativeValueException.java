package customexceptions;

public class NegativeValueException extends RuntimeException{
    public NegativeValueException() {
        super("Can't use negative value");
    }
}
