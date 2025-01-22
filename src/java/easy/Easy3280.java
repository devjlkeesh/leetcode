package easy;

public class Easy3280 {
    public String convertDateToBinary(String date) {
        StringBuilder sb = new StringBuilder();
        return sb.append(Integer.toBinaryString(Integer.parseInt(date.substring(0,4)))).append("-")
                .append(Integer.toBinaryString(Integer.parseInt(date.substring(5,7)))).append("-")
                .append(Integer.toBinaryString(Integer.parseInt(date.substring(8,10))))
                .toString();
    }
    public String convertNumberToBinaryString(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 2);
            n /=2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(2080));
        var s = new Easy3280();
        System.out.println(s.convertDateToBinary("2080-02-29"));
    }
}
