import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        Series s1 = new Series("s1", 4.5f, "2018-6-3");
        s1.addConsumptionTimeInHours(2);
        s1.addConsumptionTimeForDay(3);
        s1.setEndingDate("2019-8-7");
        System.out.println(s1.toString());
    }
}
