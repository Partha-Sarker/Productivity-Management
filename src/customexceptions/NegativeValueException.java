package customexceptions;

public class NegativeValueException extends Exception{
    public NegativeValueException() {
        super("Can't use negative value");
    }
}
