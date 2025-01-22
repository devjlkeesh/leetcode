package easy;

public class Easy1037 {
    public boolean isBoomerang(int[][] points) {
        int x1 = points[0][0], y1 = points[0][1];
        int x2 = points[1][0], y2 = points[1][1];
        int x3 = points[2][0], y3 = points[2][1];
        double area = 0.5 * Math.abs(x1 * (y3 - y2) + x2 * (y1 - y3) + x3 * (y2 - y1));
        System.out.println(area);
        return area > 0;
    }

    public static void main(String[] args) {
        Easy1037 e = new Easy1037();
        System.out.println(e.isBoomerang(new int[][]{{1, 1}, {2, 3}, {3, 2}}));
        System.out.println(e.isBoomerang(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
        System.out.println(e.isBoomerang(new int[][]{{1, 1}, {2, 2}, {7, 7}}));
    }
}
