package leetcode;

//https://leetcode.com/problems/largest-triangle-area/description
public class Easy812 {

    public double largestTriangleArea(int[][] points) {
        if (points.length == 3) {
            return calculateArea(points[0], points[1], points[2]);
        }
        double area = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    area = Math.max(area, calculateArea(points[i], points[j], points[k]));
                }
            }
        }
        return area;
    }

    public double calculateArea(int[] point1, int[] point2, int[] point3) {
        return Math.abs(0.5 * (point1[0] * (point2[1] - point3[1]) + point2[0] * (point3[1] - point1[1]) + point3[0] * (point1[1] - point2[1])));
    }

    public static void main(String[] args) {
        Easy812 easy812 = new Easy812();
        double area = easy812.largestTriangleArea(
                new int[][]{{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}}
        );
        System.out.println("area = " + area);
    }
}
