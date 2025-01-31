package leetcode;

// https://leetcode.com/problems/day-of-the-year/description/
public class Easy1154 {

    public int dayOfYear(String date) {
        int month = (date.charAt(5) - '0') * 10 + date.charAt(6) - '0';
        int day = (date.charAt(8) - '0') * 10 + date.charAt(9) - '0';
        int[] days = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
        int dayOfYear = days[month - 1] + day;
        if (month < 3) {
            return dayOfYear;
        }
        int year = Integer.parseInt(date.substring(0, 4));
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            dayOfYear++;
        }
        return dayOfYear;
    }

    public static void main(String[] args) {
        Easy1154 solution = new Easy1154();
        System.out.println(solution.dayOfYear("2019-01-09"));
        System.out.println(solution.dayOfYear("2019-02-10"));
        System.out.println(solution.dayOfYear("1900-05-02"));
    }
}
