package easy;

public class Easy1185 {
    public String dayOfTheWeek(int day, int month, int year) {
        int days = (year - 1971) * 365;
        for (int i = 1971; i < year; i++) {
            if (i % 4 == 0 && (i % 100 != 0 || i % 400 == 0)) {
                days++;
            }
        }
        int[] monthDays = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
        int dayOfYear = monthDays[month - 1] + day;
        if (month >= 3 && (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))) {
            dayOfYear++;
        }
        days += dayOfYear;
        String[] dayOfWeek = {"Friday", "Saturday","Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
        return dayOfWeek[(days - 1) % 7];
    }

    public static void main(String[] args) {
        Easy1185 test = new Easy1185();
        System.out.println(test.dayOfTheWeek(31, 8, 2019));
    }
}
