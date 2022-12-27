import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeMath {
    static LocalDateTime date = LocalDateTime.now();
    static DateTimeFormatter simpleDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    static String dateOutSoloWrite = simpleDate.format(date);
    static LocalDateTime dateTime1 = LocalDateTime.parse(dateOutSoloWrite, simpleDate);
    static LocalDateTime dateTime2 = LocalDateTime.parse(dateOutSoloWrite, simpleDate).plusHours(5);
    static long diffInSeconds = java.time.Duration.between(dateTime1, dateTime2).getSeconds();
    public static long getDiffInSeconds() {
        return diffInSeconds;
    }

    public static void setDiffInSeconds(long diffInSeconds) {
        TimeMath.diffInSeconds = diffInSeconds;
    }
}
