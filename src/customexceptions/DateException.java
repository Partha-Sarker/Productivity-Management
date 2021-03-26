package customexceptions;

public class DateException extends RuntimeException{
    public DateException() {
        super("Can't use this date");
    }
}
