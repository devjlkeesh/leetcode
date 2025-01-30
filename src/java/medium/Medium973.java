package medium;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class Medium973 {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Double[]> pq = new PriorityQueue<>(Comparator.comparingDouble(o -> o[0]));
        for (int[] point : points) {
            double x = point[0];
            double y = point[1];
            double distance = Math.sqrt(x*x + y*y);
            pq.offer(new Double[]{distance,x,y});
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            Double[] d = pq.poll();
            res[i] = new int[]{d[1].intValue(),d[2].intValue()};
        }
        return res;

    }
    public int[][] kClosest2(int[][] points, int k) {
        PriorityQueue<Map.Entry<Double,Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByKey());
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            double distance = Math.sqrt(x*x + y*y);
            pq.offer(Map.entry(distance,i));
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            var entry = pq.poll();
            res[i] = points[entry.getValue()];
        }
        return res;
    }
    public int[][] kClosest3(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1, o2) -> Integer.compare((o2[0] * o2[0] + o2[1] * o2[1]), (o1[0] * o1[0] + o1[1] * o1[1]))
        );

        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
