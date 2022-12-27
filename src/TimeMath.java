import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeMath {
    static LocalDateTime date = LocalDateTime.now();
    static DateTimeFormatter simpleDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    static final int HOURS_IN_DAY = 24;

    static String dateOutSoloWrite = simpleDate.format(date);
    static LocalDateTime dateTime1 = LocalDateTime.parse(dateOutSoloWrite, simpleDate);
    static LocalDateTime dateTime2 = LocalDateTime.parse(dateOutSoloWrite, simpleDate).plusHours(5);
    static long diffInSeconds = java.time.Duration.between(dateTime1, dateTime2).getSeconds();

    long seconds = TimeMath.getDiffInSeconds();
    public void timeMath(){
        Timer timer = new Timer(1000, e -> {
            seconds--;
            long day = seconds / 86400;
            long hours = (seconds % 86400) / 3600;
            long minutes = (seconds % 3600) / 60;
            long secondsToMin = seconds % 60;

            String timeString = String.format("%02d:%02d:%02d:%02d", day, hours, minutes, secondsToMin);

            System.out.println(timeString);
        });
        timer.start();
    }
    public static long getDiffInSeconds() {
        return diffInSeconds;
    }

    public static void setDiffInSeconds(long diffInSeconds) {
        TimeMath.diffInSeconds = diffInSeconds;
    }
}