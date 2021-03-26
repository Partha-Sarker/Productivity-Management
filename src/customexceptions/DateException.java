package customexceptions;

public class DateException extends Exception{
    public DateException() {
        super("Can't use this date");
    }
}
