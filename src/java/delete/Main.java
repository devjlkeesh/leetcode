package delete;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime now = LocalDateTime.now();
        System.out.println(isoDateTime.format(now));
        System.out.println(now);
        LocalDateTime now2 = LocalDateTime.parse("2025-02-20T06:51:00.269Z", isoDateTime);
        System.out.println(now2);
    }
}
