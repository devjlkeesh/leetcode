package leetcode;

public class Easy1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2){
            return true;
        }
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
        for (int i = 2; i < coordinates.length; i++) {
            int x3 = coordinates[i][0];
            int y3 = coordinates[i][1];
            double area = 0.5d * Math.abs(x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2));
            if (area > 0){
                return false;
            }
        }
        return true;
    }
}
