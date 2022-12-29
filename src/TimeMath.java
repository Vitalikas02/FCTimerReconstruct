import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeMath {
    static final int HOURS_IN_DAY = 24;
    //хуита
    static int modifierTime = (int) (HOURS_IN_DAY * Frame.getTimeModifier()[0]);
    DateTimeFormatter simpleDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    static long diffInSeconds;
    static String dateT1;
    static String dateT2;

    long seconds = TimeMath.getDiffInSeconds();

    public void timerSecond(){
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

    public void timeMath() {
        LocalDateTime date = LocalDateTime.now();
        String dateOutSoloWrite = simpleDate.format(date);
        LocalDateTime dateTime1 = LocalDateTime.parse(dateOutSoloWrite, simpleDate);
        LocalDateTime dateTime2 = LocalDateTime.parse(dateOutSoloWrite, simpleDate).plusHours(modifierTime);
        dateT1 = dateTime1.format(simpleDate);
        dateT2 = dateTime2.format(simpleDate);
        diffInSeconds = java.time.Duration.between(dateTime1, dateTime2).getSeconds();
    }
    public static long getDiffInSeconds() {
        return diffInSeconds;
    }

    public void setDiffInSeconds(long diffInSeconds) {
        TimeMath.diffInSeconds = diffInSeconds;
    }

    public String getDateT1() {
        return dateT1;
    }

    public void setDateT1(String dateT1) {
        TimeMath.dateT1 = dateT1;
    }

    public static String getDateT2() {
        return dateT2;
    }

    public void setDateT2(String dateT2) {
        TimeMath.dateT2 = dateT2;
    }
}